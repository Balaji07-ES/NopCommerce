package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;

    @BeforeClass
    public void setRegisterPage(){
        registerPage = pageObjectManager.getRegisterPage();
        registerPage.registerLinkClick();
    }

    @Test(priority = 1)
    public void fieldsDisplayedTest(){
        Assert.assertTrue(registerPage.isRegisterTextDisplayed());
        Assert.assertTrue(registerPage.isPersonalDetailsTextDisplayed());
        Assert.assertTrue(registerPage.isGenderTextDisplayed());
        Assert.assertTrue(registerPage.isMaleLabelDisplayed());
        Assert.assertTrue(registerPage.isFemaleLabelDisplayed());
        Assert.assertTrue(registerPage.isMaleRadioButtonDisplayed());
        Assert.assertTrue(registerPage.isFemaleRadioButtonDisplayed());
        Assert.assertTrue(registerPage.isFirstNameLabelDisplayed());
        Assert.assertTrue(registerPage.isLastNameLabelDisplayed());
        Assert.assertTrue(registerPage.isEmailLabelDisplayed());
        Assert.assertTrue(registerPage.isFirstNameInputDisplayed());
        Assert.assertTrue(registerPage.isLastNameInputDisplayed());
        Assert.assertTrue(registerPage.isEmailInputFieldDisplayed());
        Assert.assertTrue(registerPage.isCompanyDetailsLabelDisplayed());
        Assert.assertTrue(registerPage.isCompanyNameLabelDisplayed());
        Assert.assertTrue(registerPage.isCompanyInputDisplayed());
        Assert.assertTrue(registerPage.isOptionsLabelDisplayed());
        Assert.assertTrue(registerPage.isNewsletterLabelDisplayed());
        Assert.assertTrue(registerPage.newsLetterCheckBoxDisplayed());
        Assert.assertTrue(registerPage.isYourPasswordLabelDisplayed());
        Assert.assertTrue(registerPage.isPasswordLabelDisplayed());
        Assert.assertTrue(registerPage.isPasswordInputDisplayed());
        Assert.assertTrue(registerPage.isConfirmPasswordLabelDisplayed());
        Assert.assertTrue(registerPage.isConfirmPasswordInputDisplayed());
        Assert.assertTrue(registerPage.isRegisterButtonTextDisplayed());
    }

    @Test(priority = 2)
    public void registerPageLabelsTest() {

        Assert.assertEquals(registerPage.getRegisterText(), "Register");
        Assert.assertEquals(registerPage.getPersonalDetailsText(), "Your Personal Details");
        Assert.assertEquals(registerPage.getGenderText(),"Gender:");
        Assert.assertEquals(registerPage.getMaleLabelText(),"Male");
        Assert.assertEquals(registerPage.getFemaleLabelText(),"Female");
        Assert.assertEquals(registerPage.getFirstNameLabelText(),"First name:");
        Assert.assertEquals(registerPage.getLastNameLabelText(),"Last name:");
        Assert.assertEquals(registerPage.getEmailLabelText(),"Email:");
        Assert.assertEquals(registerPage.getCompanyDetailsLabelText(),"Company Details");
        Assert.assertEquals(registerPage.getOptionsLabelText(),"Options");
        Assert.assertEquals(registerPage.getCompanyNameLabelText(),"Company name:");
        Assert.assertEquals(registerPage.getNewsletterLabelText(),"Newsletter:");
        Assert.assertEquals(registerPage.getYourPasswordLabelText(),"Your Password");
        Assert.assertEquals(registerPage.getPasswordLabelText(),"Password:");
        Assert.assertEquals(registerPage.getConfirmPasswordLabelText(),"Confirm password:");
        Assert.assertEquals(registerPage.getRegisterText(),"Register");
    }

    @Test (priority = 3)
    public void genderRadioButtonTest() {
        Assert.assertTrue(registerPage.selectMaleGender());
        Assert.assertTrue(registerPage.selectFemaleGender());
    }

    @Test(priority = 4)
    public void newsletterCheckboxTest() {
        Assert.assertTrue(registerPage.selectNewsLetterCheckBox());
        Assert.assertTrue(!registerPage.deselectNewsLetterCheckBox());
    }

    @Test(priority = 5)
    public void inputFieldsTest() {
        Assert.assertEquals(registerPage.firstNameInputField("bala"),"bala");
        Assert.assertEquals(registerPage.lastNameInputField("krish"),"krish");
        Assert.assertEquals(registerPage.emailInputField("abc@gmail.com"),"abc@gmail.com");
        Assert.assertEquals(registerPage.companyInputField("xyz pvt ltd"),"xyz pvt ltd");
        Assert.assertEquals(registerPage.passwordInputField("Bala@123"),"Bala@123");
        Assert.assertEquals(registerPage.confirmPasswordInputField("Bala@123"),"Bala@123");
    }

    @Test(priority = 6)
    public void passwordMaskedTest() {
        boolean passwordMasked = registerPage.isPasswordMasked();
        boolean confirmPasswordMasked = registerPage.isConfirmPasswordMasked();
        Assert.assertTrue(passwordMasked,"password is not masked");
        Assert.assertTrue(confirmPasswordMasked, "Confirm Password is not masked");
    }

    @Test(priority = 7)
    public void registerErrorMessageTest() {
        registerPage.clearInputFields();
        registerPage.registerButtonClick();
        Assert.assertTrue(registerPage.isFirstNameErrorMessageDisplayed());
        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
        Assert.assertTrue(registerPage.isLastNameErrorMessageDisplayed());
        Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
        Assert.assertTrue(registerPage.isEmailErrorMessageDisplayed());
        Assert.assertEquals(registerPage.getEmailErrorMessageText(""), "Email is required.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText("aa"), "Please enter a valid email address.");
        Assert.assertEquals(registerPage.getEmailErrorMessageText("aa@c"), "Wrong email");
        Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
        Assert.assertEquals(registerPage.getPasswordErrorMessageText(""), "Password is required.");
        Assert.assertEquals(registerPage.getPasswordErrorMessageText("abc"), "Password must meet the following rules: must have at least 6 characters and not greater than 64 characters");
        Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageTest("abccc"),"The password and confirmation password do not match.");
    }

}
