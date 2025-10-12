package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePage.BasePage;
import utils.JavaScriptUtil;
import utils.WaitUtil;

public class ForgotPasswordPage extends BasePage {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".email")
    private WebElement emailField;

    @FindBy(css = ".password-recovery-button")
    private WebElement recoverButton;

    @FindBy(css = ".bar-notification p")
    private WebElement notificationMessage;

    @FindBy (css = ".close")
    private WebElement closeNotificationButton;

    @FindBy (id = "Email-error")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "//h1")
    private WebElement forgotPageTitle;

    @FindBy(css = "p[class='tooltip']")
    private WebElement emailTooltipMessage;

    @FindBy (css ="label[for='Email']")
    private WebElement emailInputLabel;

    public void enterEmailID(String email){
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void clickRecoverButton(){
        JavaScriptUtil.scrollToElement(driver,recoverButton);
        recoverButton.click();
    }

    public boolean isNotificationMessageDisplayed(){
        return notificationMessage.isDisplayed();
    }

    public String getNotificationMessageText(){
        return notificationMessage.getText();
    }

    public void closeNotification(){
        closeNotificationButton.click();
    }

    public boolean isNotificationClosed() throws InterruptedException {
        boolean notificationState;
        try {
            Thread.sleep(2000);
            notificationState = notificationMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            notificationState = false;
        }
        return notificationState;
    }
    public String getEmailErrorMessageText(String text){

        String errorMsg = null;

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

    public String getEmailInputFieldText(String text){
        emailField.clear();
        emailField.sendKeys(text);
        return emailField.getAttribute("value");
    }
    public boolean isForgotPageTitleDisplayed(){
        return forgotPageTitle.isDisplayed();
    }
    public String getForgotPageTitleText(){
        return forgotPageTitle.getText();
    }

    public boolean isEmailTooltipMessageDisplayed(){
        return emailTooltipMessage.isDisplayed();
    }
    public String getEmailTooltipMessageText(){
        return emailTooltipMessage.getText();
    }

    public boolean isEmailFieldDisplayed(){
        return emailField.isDisplayed();
    }



    public boolean isEmailInputLabelDisplayed(){
        return emailInputLabel.isDisplayed();
    }

    public String getEmailInputLabelText(){
        return emailInputLabel.getText();
    }
    public String getRecoverButtonText(){
        return recoverButton.getText();
    }
    public boolean isRecoverButtonDisplayed() {
        return recoverButton.isDisplayed();
    }

    public String getNotificationError(){
        String notificationError = notificationMessage.getText();
        closeNotificationButton.click();
       return notificationError;
    }

    public void clearField(){
        emailField.clear();
    }


}
