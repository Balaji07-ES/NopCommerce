package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import BasePage.BasePage;
import utils.JavaScriptUtil;
import utils.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='login-password']/input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(css = ".validation-summary-errors")
    private WebElement loginErrorMessage;

    @FindBy(css = ".validation-summary-errors li")
    private WebElement noAccountFoundErrorMessage;

    @FindBy(id = "RememberMe")
    private WebElement rememberMeCheckbox;

    @FindBy(how = How.XPATH, xpath = "//label[@for='RememberMe']")
    private WebElement rememberMeLabel;

    @FindBy(xpath = "//a[@href='/passwordrecovery']")
    private WebElement forgotPasswordLink;

    @FindBy(css = ".login-password span[class='password-eye']")
    private WebElement passwordEyeIconClose;

    @FindBy(css = ".password-eye-open")
    private WebElement passwordEyeIconOpen;

    @FindBy(id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//h1")
    private  WebElement loginPageTitle;

    @FindBy(css = ".register-block strong")
    private WebElement registerBlockTitle;

    @FindBy(css = ".register-block div[class='text']")
    private WebElement registerBlockDescription;

    @FindBy(css = ".register-button")
    private WebElement registerButton;

    @FindBy (css = ".returning-wrapper strong")
    private WebElement returningCustomerTitle;

    @FindBy(xpath = "//label[@for='Email']")
    private WebElement emailLabel;

    @FindBy(xpath = "//label[@for='Password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//label[@for='RememberMe']")
    private WebElement rememberMeTextLabel;

    @FindBy(xpath = "//h2")
    private WebElement subtitleText;

    @FindBy(css = ".topic-block-body p")
    private WebElement subtitleDescription;




    public void enterCredentials(String username, String password) {
        emailField.clear();
        passwordField.clear();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void loginButtonClick(){
        JavaScriptUtil.scrollToElement(driver,loginButton);
        WaitUtil.explicitWait(loginButton);
        loginButton.click();
    }

    public boolean isLoginErrorMessageDisplayed(){
        WaitUtil.explicitWait(loginErrorMessage);
        return loginErrorMessage.isDisplayed();
    }

    public String getLoginErrorMessageText(){
        WaitUtil.explicitWait(loginErrorMessage);
        return loginErrorMessage.getText();
    }

    public boolean isRememberMeDisplayed(){
       return rememberMeCheckbox.isDisplayed();
    }

    public boolean isRememberMeSelected(){
        boolean checkBoxStatus = false;
        if (!rememberMeCheckbox.isSelected()){
            rememberMeCheckbox.click();
            checkBoxStatus=rememberMeCheckbox.isSelected();
        }
       return checkBoxStatus;
    }

    public boolean isRememberMeDeselected(){
        boolean checkBoxStatus = false;
        if (rememberMeCheckbox.isSelected()){
            rememberMeCheckbox.click();
            checkBoxStatus=rememberMeCheckbox.isSelected();
        }
        return checkBoxStatus;
    }

    public boolean isRememberMeLabelDisplayed(){
        return rememberMeLabel.isDisplayed();
    }

    public String getRememberMeLabelText(){
        return rememberMeLabel.getText();
    }

    public String emailPreFilledValue(){
        return emailField.getAttribute("value");
    }

    public boolean isForgotPasswordLinkDisplayed() {
    	return forgotPasswordLink.isDisplayed();
    }

    public String getForgotPasswordLinkText() {
    	return forgotPasswordLink.getText();
    }

    public void forgotPasswordClick() {
    	forgotPasswordLink.click();
    }


    public boolean isPasswordMasked() {
        return  passwordField.getAttribute("type").equals("password") && passwordEyeIconClose.isDisplayed();
    }

    public boolean isPasswordUnmasked() {
        passwordEyeIconClose.click();
        return passwordField.getAttribute("type").equals("text") && passwordEyeIconOpen.isDisplayed();
    }

    public void passwordEyeIconOpenClick(){
        passwordEyeIconOpen.click();
    }

    public String getEmailErrorMessageText(String text){
        String errorMsg = null;
        emailField.clear();

        if(!text.contains("@") && !text.isEmpty()) {
            emailField.clear();
            emailField.sendKeys(text);
            WaitUtil.explicitWait(emailErrorMessage);
            errorMsg = emailErrorMessage.getText();
        }
        else if (text.contains("@")) {
            emailField.clear();
            emailField.sendKeys(text);
            WaitUtil.explicitWait(emailErrorMessage);
            errorMsg = emailErrorMessage.getText();
        }
        else {
            emailField.clear();
            emailField.sendKeys(text);
            WaitUtil.explicitWait(emailErrorMessage);
            errorMsg = emailErrorMessage.getText();
        }
        return errorMsg;
    }

    public String getEmailInputText(String text){
        emailField.clear();
        emailField.sendKeys(text);
        return emailField.getAttribute("value");
    }

    public String getPasswordInputText(String text){
        passwordField.clear();
        passwordField.sendKeys(text);
        return passwordField.getAttribute("value");
    }

    public boolean isLoginPageTitleDisplayed(){
        return loginPageTitle.isDisplayed();
    }

    public String getLoginPageTitleText(){
        return loginPageTitle.getText();
    }

    public boolean isRegisterBlockTitleDisplayed(){
        return registerBlockTitle.isDisplayed();
    }

    public String getRegisterBlockTitleText() {
        return registerBlockTitle.getText();
    }

    public boolean isRegisterBlockDescriptionDisplayed() {
        return registerBlockDescription.isDisplayed();
    }

    public String getRegisterBlockDescriptionText() {
        return registerBlockDescription.getText();
    }

    public boolean isRegisterButtonDisplayed() {
        return registerButton.isDisplayed();
    }

    public String getRegisterButtonText() {
        return registerButton.getText();
    }

    public boolean isReturningCustomerTitleDisplayed() {
        return returningCustomerTitle.isDisplayed();
    }

    public String getReturningCustomerTitleText() {
        return returningCustomerTitle.getText();
    }

    public boolean isEmailLabelDisplayed() {
        return emailLabel.isDisplayed();
    }

    public String getEmailLabelText() {
        return emailLabel.getText();
    }

    public boolean isPasswordLabelDisplayed() {
        return passwordLabel.isDisplayed();
    }

    public String getPasswordLabelText() {
        return passwordLabel.getText();
    }

    public boolean isRememberMeTextLabelDisplayed() {
        return rememberMeTextLabel.isDisplayed();
    }
    public String getRememberMeTextLabelText() {
        return rememberMeTextLabel.getText();
    }

    public boolean isSubtitleTextDisplayed() {
        return subtitleText.isDisplayed();
    }

    public String getSubtitleText() {
        return subtitleText.getText();
    }

    public boolean isSubtitleDescriptionDisplayed() {
        return subtitleDescription.isDisplayed();
    }
    public String getSubtitleDescriptionText() {
        return subtitleDescription.getText();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

    public void clearFields() {
        emailField.clear();
        passwordField.clear();
    }

    public boolean isEmailFieldDisplayed() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isPasswordEyeIconDisplayed() {
        return passwordEyeIconClose.isDisplayed();
    }

    public void registerButtonClick() {
    	registerButton.click();
    }

    public String getRegisterRedirectUrl() {
    	return driver.getCurrentUrl();
    }

    public String getRegisterRedirectPageTitle() {
    	return driver.getTitle();
    }

    public String getForgotPasswordRedirectUrl() {
    	return driver.getCurrentUrl();
    }

    public String getForgotPasswordRedirectPageTitle() {
    	return driver.getTitle();
    }

    public String getLoginPageRedirectUrl() {
    	return driver.getCurrentUrl();
    }

    public String getLoginPageRedirectPageTitle() {
    	return driver.getTitle();
    }



}
