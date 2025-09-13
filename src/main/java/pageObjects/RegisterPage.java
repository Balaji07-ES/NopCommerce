package pageObjects;

import ReusableComponents.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1")
    private WebElement registerLabel;

    @FindBy(xpath = "(//div[@class='title']/strong)[1]")
    private WebElement personalDetailsLabel;

    @FindBy(xpath = "//label[@for='gender']")
    private WebElement genderLabel;

    @FindBy(xpath = "//label[@for='FirstName']")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//label[@for='LastName']")
    private WebElement lastNameLabel;

    @FindBy(xpath = "//label[@for='Email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='Password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//label[@for='ConfirmPassword']")
    private WebElement confirmPasswordLabel;

    @FindBy(id = "gender-male")
    private  WebElement maleRadioButton;

    @FindBy(id="gender-female")
    private WebElement femaleRadioButton;

    @FindBy(xpath = "//label[@for='gender-male']")
    private WebElement maleLabel;

    @FindBy(xpath = "//label[@for='gender-female']")
    private WebElement femaleLabel;

    @FindBy (xpath = "(//div[@class='title']/strong)[2]")
    private WebElement companyDetailsLabel;

    @FindBy(xpath = "(//div[@class='title']/strong)[3]")
    private WebElement optionsLabel;

    @FindBy(xpath = "(//div[@class='title']/strong)[4]")
    private WebElement yourPasswordLabel;

    @FindBy(xpath = "//label[@for='Company']")
    private WebElement companyNameLabel;

    @FindBy(xpath = "//label[@for='Newsletter']")
    private WebElement newsletterLabel;

    @FindBy(xpath = "//button[@id='register-button']")
    private WebElement registerButton;




    public void registerLinkClick(){
      registerLink.click();
    }
    // Checks if the register label is displayed
    public boolean isRegisterTextDisplayed() {
        return registerLabel.isDisplayed();
    }
    // Returns the register label text
    public String getRegisterText() {
        return registerLabel.getText();
    }

    // Returns the personal details label text
    public String getPersonalDetailsText() {
        return personalDetailsLabel.getText();
    }

    // Checks if the personal details label is displayed
    public boolean isPersonalDetailsTextDisplayed() {
        return personalDetailsLabel.isDisplayed();
    }

    // Returns the gender label text
    public String getGenderText() {
        return genderLabel.getText();
    }

    // Checks if the gender label is displayed
    public boolean isGenderTextDisplayed() {
        return genderLabel.isDisplayed();
    }

    //Male Label
    public String getMaleLabelText() {
        return maleLabel.getText();
    }
    public boolean isMaleLabelDisplayed() {
        return maleLabel.isDisplayed();
    }
    //Female Label
    public String getFemaleLabelText() {
        return femaleLabel.getText();
    }
    public boolean isFemaleLabelDisplayed() {
        return femaleLabel.isDisplayed();
    }

    // First Name
    public String getFirstNameLabelText() {
        return firstNameLabel.getText();
    }
    public boolean isFirstNameLabelDisplayed() {
        return firstNameLabel.isDisplayed();
    }

    // Last Name
    public String getLastNameLabelText() {
        return lastNameLabel.getText();
    }
    public boolean isLastNameLabelDisplayed() {
        return lastNameLabel.isDisplayed();
    }

    // Email
    public String getEmailLabelText() {
        return emailLabel.getText();
    }
    public boolean isEmailLabelDisplayed() {
        return emailLabel.isDisplayed();
    }

    // Password
    public String getPasswordLabelText() {
        return passwordLabel.getText();
    }
    public boolean isPasswordLabelDisplayed() {
        return passwordLabel.isDisplayed();
    }

    // Confirm Password
    public String getConfirmPasswordLabelText() {
        return confirmPasswordLabel.getText();
    }
    public boolean isConfirmPasswordLabelDisplayed() {
        return confirmPasswordLabel.isDisplayed();
    }

    // Company Details
    public boolean isCompanyDetailsLabelDisplayed() {
        return companyDetailsLabel.isDisplayed();
    }
    public String getCompanyDetailsLabelText() {
        return companyDetailsLabel.getText();
    }
    //
    public boolean isCompanyNameLabelDisplayed() {
        return companyNameLabel.isDisplayed();
    }
    public String getCompanyNameLabelText() {
        return companyNameLabel.getText();
    }
    // Options
    public boolean isOptionsLabelDisplayed() {
        return optionsLabel.isDisplayed();
    }
    public String getOptionsLabelText() {
        return optionsLabel.getText();
    }
    // Newsletter
    public boolean isNewsletterLabelDisplayed() {
        return newsletterLabel.isDisplayed();
    }
    public String getNewsletterLabelText() {
        return newsletterLabel.getText();
    }

    // Your Password
    public boolean isYourPasswordLabelDisplayed() {
        return yourPasswordLabel.isDisplayed();
    }
    public String getYourPasswordLabelText() {
        return yourPasswordLabel.getText();
    }

   // MaleRadioButton
   public void selectMaleGender() {
        if (!maleRadioButton.isSelected()) {
            maleRadioButton.click();
        }
    }
    public boolean isMaleRadioButtonSelected() {
        return maleRadioButton.isSelected();
    }

    //FemaleRadioButton
    public void selectFemaleGender() {
        if (!femaleRadioButton.isSelected()) {
            femaleRadioButton.click();
        }
    }

    public boolean isFemaleRadioButtonSelected() {
        return femaleRadioButton.isSelected();
    }

    //Register Button
    public boolean isRegisterButtonTextDisplayed() {
        return registerButton.isDisplayed();
    }
    public String getRegisterButtonText() {
        return registerButton.getText();
    }


}
