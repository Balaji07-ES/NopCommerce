package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        System.out.println("Setting up the test environment...");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
//        System.out.println("Tearing down the test environment...");
        driver.quit();
    }
}
