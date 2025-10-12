package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginE2ETest extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void setLoginPage(){
        loginPage = pageObjectManager.getLoginPage();
        loginPage.navigateToLoginPage();
    }

    @Test
    public void invalidUserLoginTest() {
        loginPage.enterCredentials("123123@gmail.com", "123456");
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.isLoginErrorMessageDisplayed());
        Assert.assertEquals(loginPage.getLoginErrorMessageText(),"Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

    }

    @Test
    public void validUserLoginTest() {
        loginPage.enterCredentials(regEmailID, regPassword);
        loginPage.loginButtonClick();
        Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
        Assert.assertTrue(loginPage.isMyAccountLinkDisplayed());
    }
}


