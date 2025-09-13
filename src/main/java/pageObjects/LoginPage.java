package pageObjects;

import ReusableComponents.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Header {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement loginButton;

    @FindBy(css = ".validation-summary-errors")
    private WebElement errorMessage;



    public void loginStep(String username, String password) {
        navigateToLoginPage();
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

    }

    public boolean checkErrorMessage(){
        return errorMessage.isDisplayed();
    }
}
