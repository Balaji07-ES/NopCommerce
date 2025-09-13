package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.PageObjectManager;
import pageObjects.RegisterPage;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage;

    @BeforeClass
    public void setRegisterPage(){
        PageObjectManager pageObjectManager = new PageObjectManager(driver);
        registerPage = pageObjectManager.getRegisterPage();
        registerPage.registerLinkClick();
    }

    @Test
    public void registerPageLabelsTest() {
        Assert.assertTrue(registerPage.isRegisterTextDisplayed());
        Assert.assertEquals(registerPage.getRegisterText(), "Register");
        Assert.assertTrue(registerPage.isPersonalDetailsTextDisplayed());
        Assert.assertEquals(registerPage.getPersonalDetailsText(), "Your Personal Details");
        Assert.assertTrue(registerPage.isGenderTextDisplayed());
        Assert.assertEquals(registerPage.getGenderText(),"Gender:");
        Assert.assertTrue(registerPage.isMaleLabelDisplayed());
        Assert.assertEquals(registerPage.getMaleLabelText(),"Male");
        Assert.assertTrue(registerPage.isFemaleLabelDisplayed());
        Assert.assertEquals(registerPage.getFemaleLabelText(),"Female");
        Assert.assertTrue(registerPage.isFirstNameLabelDisplayed());
        Assert.assertEquals(registerPage.getFirstNameLabelText(),"First name:");
        Assert.assertTrue(registerPage.isLastNameLabelDisplayed());
        Assert.assertEquals(registerPage.getLastNameLabelText(),"Last name:");
        Assert.assertTrue(registerPage.isEmailLabelDisplayed());
        Assert.assertEquals(registerPage.getEmailLabelText(),"Email:");
        Assert.assertTrue(registerPage.isCompanyDetailsLabelDisplayed());
        Assert.assertEquals(registerPage.getCompanyDetailsLabelText(),"Company Details");
        Assert.assertTrue(registerPage.isOptionsLabelDisplayed());
        Assert.assertEquals(registerPage.getOptionsLabelText(),"Options");
        Assert.assertTrue(registerPage.isCompanyNameLabelDisplayed());
        Assert.assertEquals(registerPage.getCompanyNameLabelText(),"Company name:");
        Assert.assertTrue(registerPage.isNewsletterLabelDisplayed());
        Assert.assertEquals(registerPage.getNewsletterLabelText(),"Newsletter:");
        Assert.assertTrue(registerPage.isYourPasswordLabelDisplayed());
        Assert.assertEquals(registerPage.getYourPasswordLabelText(),"Your Password");
        Assert.assertTrue(registerPage.isPasswordLabelDisplayed());
        Assert.assertEquals(registerPage.getPasswordLabelText(),"Password:");
        Assert.assertTrue(registerPage.isConfirmPasswordLabelDisplayed());
        Assert.assertEquals(registerPage.getConfirmPasswordLabelText(),"Confirm password:");
        Assert.assertTrue(registerPage.isRegisterButtonTextDisplayed());
        Assert.assertEquals(registerPage.getRegisterText(),"Register");
    }

    @Test
    public void genderRadioButtonTest() {
      registerPage.selectMaleGender();
      registerPage.isMaleRadioButtonSelected();
      registerPage.selectFemaleGender();
      registerPage.isFemaleRadioButtonSelected();
    }
}
