package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;

public class ForgotPasswordTest extends BaseTest {
    ForgotPasswordPage forgotPasswordPage;
    LoginPage loginPage;

    @BeforeClass
    public void setForgotPasswordPage(){
        forgotPasswordPage = pageObjectManager.getForgotPasswordPage();
        loginPage = pageObjectManager.getLoginPage();
        forgotPasswordPage.navigateToLoginPage();
        loginPage.forgotPasswordClick();
    }
    @Test(priority = 1)
    public void fieldDisplayedTest(){
        Assert.assertTrue(forgotPasswordPage.isForgotPageTitleDisplayed());
        Assert.assertTrue(forgotPasswordPage.isEmailTooltipMessageDisplayed());
        Assert.assertTrue(forgotPasswordPage.isEmailFieldDisplayed());
        Assert.assertTrue(forgotPasswordPage.isEmailInputLabelDisplayed());
        Assert.assertTrue(forgotPasswordPage.isRecoverButtonDisplayed());
    }

    @Test(priority = 2)
    public void labelTest(){
        Assert.assertEquals(forgotPasswordPage.getForgotPageTitleText(),"Password recovery");
        Assert.assertEquals(forgotPasswordPage.getEmailTooltipMessageText(),"Please enter your email address below. You will receive a link to reset your password.");
        Assert.assertEquals(forgotPasswordPage.getEmailInputLabelText(),"Your email address:");
        Assert.assertEquals(forgotPasswordPage.getEmailInputFieldText(regEmailID),regEmailID);
        Assert.assertEquals(forgotPasswordPage.getRecoverButtonText(),"RECOVER");

    }

    @Test(priority = 4)
    public void forgotErrorMessageTest(){
        forgotPasswordPage.clearField();
        forgotPasswordPage.clickRecoverButton();
        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessageText(""), "Enter your email");
        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessageText("aa"), "Please enter a valid email address.");
        Assert.assertEquals(forgotPasswordPage.getEmailErrorMessageText("aa@c"), "Wrong email");
        forgotPasswordPage.enterEmailID("a1as@c.com");
        forgotPasswordPage.clickRecoverButton();
        Assert.assertEquals(forgotPasswordPage.getNotificationError(),"Email not found.");
    }

    @Test(priority = 3)
    public void notificationBarTest() throws InterruptedException {
        forgotPasswordPage.enterEmailID(regEmailID);
        forgotPasswordPage.clickRecoverButton();
        Assert.assertTrue(forgotPasswordPage.isNotificationMessageDisplayed());
        Assert.assertEquals(forgotPasswordPage.getNotificationMessageText(), "Email with instructions has been sent to you.");
        forgotPasswordPage.closeNotification();
        Assert.assertFalse(forgotPasswordPage.isNotificationClosed());
    }
}
