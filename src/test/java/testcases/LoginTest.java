package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Test
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.loginStep("123123@gmail.com", "123456");
        boolean errorMessageDisplayed = loginPage.checkErrorMessage();
        Assert.assertTrue(errorMessageDisplayed);
    }
}


