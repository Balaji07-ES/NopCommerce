package ReusableComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//a[text()='Log in']")
    protected WebElement loginLink;


    public void navigateToLoginPage() {
        loginLink.click();
    }
}
