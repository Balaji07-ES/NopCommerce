package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {
    static WebDriver driver;
    static WebDriverWait wait;


    public static void waitInitialize(WebDriver driver){
        WaitUtil.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public static void explicitWait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

   public static void alertExplicitWait(){
       wait.until(ExpectedConditions.alertIsPresent());
   }

   public static void waitAllItems(List<WebElement> list){
        wait.until(ExpectedConditions.visibilityOfAllElements(list));
   }

   public static void pageLoadWait(){
       wait.until(driver -> ((JavascriptExecutor) driver)
               .executeScript("return document.readyState")
               .equals("complete"));

   }








}
