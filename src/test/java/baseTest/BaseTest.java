package baseTest;

import managers.DriverManager;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.WaitUtil;
import utils.ConfigReader;
import utils.RegisterUserRandomText;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
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

    @Parameters({"browser"})
    @BeforeClass()
    public void setUp(String browser) {
        DriverManager.setDriver(browser);
        driver = DriverManager.getDriver();
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
         if (driver != null) {
            driver.quit();
           }
         }
}
