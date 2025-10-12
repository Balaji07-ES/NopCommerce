package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

    public static void howeverState(WebDriver driver, WebElement element){
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }
}
