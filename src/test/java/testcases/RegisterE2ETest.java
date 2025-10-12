package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class RegisterE2ETest extends BaseTest {
   RegisterPage registerPage;

    @BeforeClass
    public void setRegisterPage(){
        registerPage = pageObjectManager.getRegisterPage();
        registerPage.registerLinkClick();
    }

    @Test(priority = 1)
    public void registerAccountTest() {
        registerPage.registerLinkClick();
        registerPage.selectMaleGender();
        registerPage.firstNameInputField(regFirstName);
        registerPage.lastNameInputField(regLastName);
        registerPage.emailInputField(regEmailID);
        registerPage.companyInputField(companyName);
        registerPage.passwordInputField(regPassword);
        registerPage.confirmPasswordInputField(regPassword);
        registerPage.registerButtonClick();
        registerPage.isRegisterSuccessMessageDisplayed();
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
        registerPage.continueButtonClick();
        registerPage.logOutClick();
    }

    @Test(priority = 2)
    public void existingUserRegisterTest() {
        registerPage.registerLinkClick();
        registerPage.selectMaleGender();
        registerPage.firstNameInputField(firstName);
        registerPage.lastNameInputField(lastName);
        registerPage.emailInputField(regEmailID);
        registerPage.companyInputField(companyName);
        registerPage.passwordInputField(password);
        registerPage.confirmPasswordInputField(password);
        registerPage.registerButtonClick();
        registerPage.isExistingEmailErrorMessageDisplayed();
        Assert.assertEquals(registerPage.getExistingEmailErrorMessageText(),"The specified email already exists");
    }
}
