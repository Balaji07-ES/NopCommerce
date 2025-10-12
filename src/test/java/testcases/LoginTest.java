package testcases;

import baseTest.BaseTest;
import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.ForgotPasswordPage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {
LoginPage loginPage;


@BeforeClass
public void setLoginPage(){
    loginPage = pageObjectManager.getLoginPage();
    loginPage.navigateToLoginPage();
}

@Test(priority = 5)
    public void rememberMeTest(){
    loginPage.enterCredentials(regEmailID, regPassword);
    Assert.assertTrue(loginPage.isRememberMeDisplayed());
    Assert.assertTrue(loginPage.isRememberMeSelected());
    Assert.assertFalse(loginPage.isRememberMeDeselected());
    Assert.assertTrue(loginPage.isRememberMeLabelDisplayed());
    Assert.assertEquals(loginPage.getRememberMeLabelText(),"Remember me?");
    loginPage.loginButtonClick();
    loginPage.logOutClick();
    loginPage.navigateToLoginPage();
//    Assert.assertEquals(loginPage.emailPreFilledValue(),regEmailID);
    }

    @Test(priority = 3)
    public void passwordMaskedToggleTest() {
        Assert.assertTrue(loginPage.isPasswordMasked());
        Assert.assertTrue(loginPage.isPasswordUnmasked());
        loginPage.passwordEyeIconOpenClick();
        Assert.assertTrue(loginPage.isPasswordMasked());
    }

    @Test(priority = 4)
    public void loginErrorMessageTest() {
        loginPage.clearFields();
        loginPage.loginButtonClick();
        Assert.assertEquals(loginPage.getEmailErrorMessageText(""), "Please enter your email");
        Assert.assertEquals(loginPage.getEmailErrorMessageText("aa"), "Please enter a valid email address.");
        Assert.assertEquals(loginPage.getEmailErrorMessageText("aa@c"), "Wrong email");
    }

    @Test(priority = 2)
    public void inputFieldsTest() {
        Assert.assertEquals(loginPage.getEmailInputText(regEmailID), regEmailID);
        Assert.assertEquals(loginPage.getPasswordInputText(regPassword), regPassword);
    }

    @Test(priority = 1 )
    public void labelsTest() {
        Assert.assertEquals(loginPage.getLoginPageTitleText(), "Welcome, Please Sign In!");
        Assert.assertEquals(loginPage.getEmailLabelText(), "Email:");
        Assert.assertEquals(loginPage.getPasswordLabelText(), "Password:");
        Assert.assertEquals(loginPage.getLoginButtonText(), "LOG IN");
        Assert.assertEquals(loginPage.getRegisterBlockDescriptionText(),"By creating an account on our website, you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.");
        Assert.assertEquals(loginPage.getRegisterBlockTitleText(),"New Customer");
        Assert.assertEquals(loginPage.getRegisterButtonText(), "REGISTER");
        Assert.assertEquals(loginPage.getReturningCustomerTitleText(), "Returning Customer");
        Assert.assertEquals(loginPage.getSubtitleText(),"About login / registration");
        Assert.assertEquals(loginPage.getSubtitleDescriptionText(),"Put your login / registration information here. You can edit this in the admin site.");
    }

    @Test(priority = 0)
    public void fieldsDisplayedTest(){
        Assert.assertTrue(loginPage.isLoginPageTitleDisplayed());
        Assert.assertTrue(loginPage.isRegisterBlockTitleDisplayed());
        Assert.assertTrue(loginPage.isRegisterBlockDescriptionDisplayed());
        Assert.assertTrue(loginPage.isRegisterBlockDescriptionDisplayed());
        Assert.assertTrue(loginPage.isRegisterButtonDisplayed());
        Assert.assertTrue(loginPage.isReturningCustomerTitleDisplayed());
        Assert.assertTrue(loginPage.isEmailLabelDisplayed());
        Assert.assertTrue(loginPage.isPasswordLabelDisplayed());
        Assert.assertTrue(loginPage.isRememberMeDisplayed());
        Assert.assertTrue(loginPage.isRememberMeLabelDisplayed());
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
        Assert.assertTrue(loginPage.isEmailFieldDisplayed());
        Assert.assertTrue(loginPage.isPasswordFieldDisplayed());
        Assert.assertTrue(loginPage.isPasswordEyeIconDisplayed());
        Assert.assertTrue(loginPage.isForgotPasswordLinkDisplayed());
        Assert.assertTrue(loginPage.isSubtitleTextDisplayed());
        Assert.assertTrue(loginPage.isSubtitleDescriptionDisplayed());
    }

    @Test(priority = 6)
    public void buttonRedirectTest() {
        loginPage.registerButtonClick();
        Assert.assertEquals(loginPage.getRegisterRedirectUrl(),"https://demo.nopcommerce.com/register?returnUrl=%2F");
        Assert.assertEquals(loginPage.getRegisterRedirectPageTitle(),"nopCommerce demo store. Register");
        loginPage.navigateToLoginPage();
        loginPage.enterCredentials(regEmailID, regPassword);
        loginPage.loginButtonClick();
        Assert.assertEquals(loginPage.getLoginPageRedirectUrl(),"https://demo.nopcommerce.com/");
        Assert.assertEquals(loginPage.getLoginPageRedirectPageTitle(),"nopCommerce demo store. Home page title");
        loginPage.logOutClick();
        loginPage.navigateToLoginPage();
        loginPage.forgotPasswordClick();
        Assert.assertEquals(loginPage.getForgotPasswordRedirectUrl(),"https://demo.nopcommerce.com/passwordrecovery");
        Assert.assertEquals(loginPage.getForgotPasswordRedirectPageTitle(),"nopCommerce demo store. Password Recovery");
}


}
