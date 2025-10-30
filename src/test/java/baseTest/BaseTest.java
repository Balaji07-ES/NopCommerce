package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverManager;
import managers.PageObjectManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import utils.WaitUtil;
import utils.ConfigReader;
import utils.RegisterUserRandomText;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public String url = "https://demo.nopcommerce.com/";
    public PageObjectManager pageObjectManager;
    public String firstName;
    public String lastName;
    public String emailID;
    public String password;
    public String companyName;
    public String regFirstName = RegisterUserRandomText.getFirstName();
    public String regLastName = RegisterUserRandomText.getLastName();
    public String regEmailID = RegisterUserRandomText.getEmailID();
    public String regPassword = RegisterUserRandomText.getPassword();


    @BeforeClass()
    public void setUp() {
        String mode = ConfigReader.getProperty("executionMode");
        String browser= ConfigReader.getProperty("browser");
        ChromeOptions options = new ChromeOptions();
        if (mode.contains("headless")) {
            options.addArguments("--headless");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));
        }
        else {
            DriverManager.setDriver(browser);
            driver = DriverManager.getDriver();
        }
        driver.get(url);
        pageObjectManager = new PageObjectManager(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WaitUtil.waitInitialize(driver);
        firstName= ConfigReader.getProperty("firstName");
        lastName= ConfigReader.getProperty("lastName");
        emailID= ConfigReader.getProperty("email");
        password= ConfigReader.getProperty("pass");
        companyName= ConfigReader.getProperty("companyName");
        regFirstName= RegisterUserRandomText.getFirstName();
        regLastName= RegisterUserRandomText.getLastName();
        System.out.println("registered email -- > " + regEmailID);
        System.out.println("registered password -- > " + regPassword);
    }

    @AfterClass
    public void tearDown () {
//  System.out.println("Tearing down the test environment...");
         DriverManager.quitDriver();
         }

    public String getScreenShots(String TestcaseName) throws IOException {
        File img= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest= new File(System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png");
        FileUtils.copyFile(img, dest);
        return System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";

    }
}

