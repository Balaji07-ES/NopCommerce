package managers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }
    public static void setDriver(String browser) {
        WebDriver driverInstance =null;

        switch (browser) {
            case "desktopChrome":
                driverInstance = new ChromeDriver();
                driverInstance.manage().window().maximize();
                break;
            case "desktopFirefox":
                driverInstance = new FirefoxDriver();
                driverInstance.manage().window().maximize();
                break;
            case "mobileChrome":
                driverInstance = new ChromeDriver();
                driverInstance.manage().window().setSize(new Dimension(375, 812));
                break;
            case "tabletChrome":
                driverInstance = new ChromeDriver();
                driverInstance.manage().window().setSize(new Dimension(768, 1024));
                break;
            default:
                System.out.println("Browser not supported");
                break;
        }
        driver.set(driverInstance);
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
