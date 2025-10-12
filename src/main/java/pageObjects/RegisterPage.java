package pageObjects;

import BasePage.BasePage;
import utils.WaitUtil;
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

    @FindBy(xpath = "//label[@for='Newsletter']/following-sibling::input")
    private WebElement newsLetterCheckBox;

    @FindBy(xpath = "//label[@for='FirstName']/following-sibling::input")
    private WebElement firstNameInput;

    @FindBy(xpath = "//label[@for='LastName']/following-sibling::input")
    private WebElement lastNameInput;

    @FindBy(xpath = "//label[@for='Email']/following-sibling::input")
    private WebElement emailInput;

    @FindBy(xpath = "//label[@for='Company']/following-sibling::input")
    private WebElement companyInput;

    @FindBy(xpath = "//label[@for='Password']/following-sibling::input")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[@for='ConfirmPassword']/following-sibling::input")
    private WebElement confirmPasswordInput;

    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMessage;

    @FindBy(id = "LastName-error")
    private WebElement lastNameErrorMessage;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(id="Password-error")
    private WebElement passwordErrorMessage;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordErrorMessage;

    @FindBy(xpath = "//div[@class='page-body']/div[1]")
    WebElement registerSuccessMessage;

    @FindBy(css = ".validation-summary-errors li")
    WebElement existingEmailErrorMessage;

    @FindBy (css = ".register-continue-button")
    WebElement continueButton;


    public void registerLinkClick(){
       WaitUtil.explicitWait(registerLink);
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
   public boolean selectMaleGender() {
       boolean buttonState = false;
        if (!maleRadioButton.isSelected()) {
            maleRadioButton.click();
            buttonState = maleRadioButton.isSelected();
        }
        return buttonState;

    }

    public boolean isMaleRadioButtonDisplayed() {
        return maleRadioButton.isDisplayed();
    }

    //FemaleRadioButton
    public boolean selectFemaleGender() {
        boolean buttonState = false;
        if (!femaleRadioButton.isSelected()) {
            femaleRadioButton.click();
            buttonState = femaleRadioButton.isSelected();
        }
        return buttonState;
    }

    public boolean isFemaleRadioButtonDisplayed() {
        return femaleRadioButton.isDisplayed();
    }

    //Register Button
    public boolean isRegisterButtonTextDisplayed() {
        return registerButton.isDisplayed();
    }
    public String getRegisterButtonText() {
        return registerButton.getText();
    }

    public boolean newsLetterCheckBoxDisplayed() {
       return newsLetterCheckBox.isDisplayed();
    }

    public boolean selectNewsLetterCheckBox() {
        boolean buttonState = false;
        if (newsLetterCheckBox.isSelected()==true) {
            buttonState = newsLetterCheckBox.isSelected();
        }
        else  {
            newsLetterCheckBox.click();
            buttonState = newsLetterCheckBox.isSelected();
        }
        return buttonState;
    }

    public boolean deselectNewsLetterCheckBox() {
        boolean buttonState = false;
        if (newsLetterCheckBox.isSelected()==true) {
            newsLetterCheckBox.click();
            buttonState = newsLetterCheckBox.isSelected();
        }
        return buttonState;

    }

    public boolean isFirstNameInputDisplayed(){
        return firstNameInput.isDisplayed();
    }

    public String firstNameInputField(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
        return firstNameInput.getAttribute("value");
    }

    public boolean isLastNameInputDisplayed(){
        return lastNameInput.isDisplayed();
    }

    public String lastNameInputField(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
        return lastNameInput.getAttribute("value");
    }

    public boolean isEmailInputFieldDisplayed(){
        return emailInput.isDisplayed();
    }

    public String emailInputField(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
        return emailInput.getAttribute("value");
    }

    public boolean isCompanyInputDisplayed(){
        return companyInput.isDisplayed();
    }

    public String companyInputField(String company) {
        companyInput.clear();
        companyInput.sendKeys(company);
        return companyInput.getAttribute("value");
    }

    public boolean isPasswordInputDisplayed(){
        return passwordInput.isDisplayed();
    }

    public String passwordInputField(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
        return passwordInput.getAttribute("value");
    }

    public boolean isConfirmPasswordInputDisplayed(){
        return confirmPasswordInput.isDisplayed();
    }

    public String confirmPasswordInputField(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        return confirmPasswordInput.getAttribute("value");
    }

    public boolean isPasswordMasked(){
       return passwordInput.getAttribute("type").equals("password");
    }

    public boolean isConfirmPasswordMasked(){
        return confirmPasswordInput.getAttribute("type").equals("password");
    }

    public void clearInputFields(){
        firstNameInput.clear();
        lastNameInput.clear();
        emailInput.clear();
        passwordInput.clear();
        companyInput.clear();
        confirmPasswordInput.clear();
    }

    public boolean isFirstNameErrorMessageDisplayed(){
        WaitUtil.explicitWait(firstNameErrorMessage);
        return firstNameErrorMessage.isDisplayed();
    }

    public boolean isLastNameErrorMessageDisplayed(){
        WaitUtil.explicitWait(lastNameErrorMessage);
        return lastNameErrorMessage.isDisplayed();
    }

    public boolean isEmailErrorMessageDisplayed(){
        WaitUtil.explicitWait(emailErrorMessage);
        return emailErrorMessage.isDisplayed();
    }

    public boolean isPasswordErrorMessageDisplayed() {
        WaitUtil.explicitWait(confirmPasswordErrorMessage);
        return confirmPasswordErrorMessage.isDisplayed();
    }

    public String getFirstNameErrorMessageText(){
        return firstNameErrorMessage.getText();
    }

    public String getLastNameErrorMessageText(){
        return lastNameErrorMessage.getText();
    }

    public String getEmailErrorMessageText(String text){
        String errorMsg = null;
        if(!text.contains("@") && !text.isEmpty()) {
            emailInput.clear();
            emailInput.sendKeys(text);
            WaitUtil.explicitWait(emailErrorMessage);
            errorMsg = emailErrorMessage.getText();
        }
        else if (text.contains("@")) {
            emailInput.clear();
            emailInput.sendKeys(text);
            WaitUtil.explicitWait(emailErrorMessage);
            errorMsg = emailErrorMessage.getText();
        }
        else {
            emailInput.clear();
            WaitUtil.explicitWait(emailErrorMessage);
            errorMsg = emailErrorMessage.getText();
        }
        return errorMsg;
    }
    public String getPasswordErrorMessageText(String password) {
        String errorMsg = null;
        if (password.isEmpty()) {
            passwordInput.clear();
            WaitUtil.explicitWait(confirmPasswordErrorMessage);
            errorMsg = confirmPasswordErrorMessage.getText();
        }
        else if (password.length()<6){
            passwordInput.clear();
            passwordInput.sendKeys(password);
            confirmPasswordInput.sendKeys("");
            WaitUtil.explicitWait(passwordErrorMessage);
            errorMsg = passwordErrorMessage.getText();
        }
        return errorMsg;
    }

    public String getConfirmPasswordErrorMessageTest(String confirmPassword) {
        passwordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
        WaitUtil.explicitWait(confirmPasswordErrorMessage);
        return confirmPasswordErrorMessage.getText();
    }

    public void registerButtonClick() {
        WaitUtil.explicitWait(registerButton);
        registerButton.click();
    }

    public boolean isRegisterSuccessMessageDisplayed() {
        WaitUtil.explicitWait(registerSuccessMessage);
        return registerSuccessMessage.isDisplayed();
    }
    public String getRegisterSuccessMessageText() {
        return registerSuccessMessage.getText();
    }

    public boolean isExistingEmailErrorMessageDisplayed() {
        WaitUtil.explicitWait(existingEmailErrorMessage);
        return existingEmailErrorMessage.isDisplayed();
    }
    public String getExistingEmailErrorMessageText() {
        return existingEmailErrorMessage.getText();
    }

    public void continueButtonClick(){
        continueButton.click();
    }
}
