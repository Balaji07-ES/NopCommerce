package ReusableComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//a[text()='Log in']")
    protected WebElement loginLink;

    @FindBy(xpath = "//a[text()='Register']")
    protected WebElement registerLink;


    public void navigateToLoginPage() {
        loginLink.click();
    }

    public void navigateToRegisterPage() {
        registerLink.click();
    }
}
