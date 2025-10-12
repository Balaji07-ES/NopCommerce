package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class SampleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/custom-t-shirt");
        List<WebElement> lb = driver.findElements(By.xpath("//dt"));
//        WebElement attributeDropdown = driver.findElement(By.xpath("(//label[@class='text-prompt']/following::dd/select)[1]"));
        Thread.sleep(3000);
//        driver.findElement(By.cssSelector(".button-1.add-to-cart-button")).click();

        System.out.println(lb.size());
        for (int i = 0; i < lb.size(); i++) {
            System.out.println(lb.get(i).getText());

            if (lb.get(i).getText().contains("Processor")) {
                WebElement processorDropdown = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/select"));
                new Select(processorDropdown).selectByIndex(2);
            }
            else if (lb.get(i).getText().contains("RAM")) {
                WebElement ramDropdown = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/select"));
                new Select(ramDropdown).selectByIndex(2);
            }
            else if (lb.get(i).getText().contains("HDD")) {
                WebElement radioBoxHDD = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/ul/li[2]/input"));
                radioBoxHDD.click();
            }
            else if (lb.get(i).getText().contains("OS")) {
                WebElement radioBoxOS = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/ul/li[2]/input"));
                radioBoxOS.click();

            }
            else if (lb.get(i).getText().contains("Software")) {
                WebElement checkboxSoftware = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/ul/li[2]/input"));
                checkboxSoftware.click();
            }
            else if (lb.get(i).getText().contains("Color")) {
                try {
                    WebElement colorPicker = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/ul/li[2]/label"));
                    colorPicker.click();
                } catch (Exception e) {
                    WebElement colorDropdown = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/select"));
                    new Select(colorDropdown).selectByIndex(2);
                }


            }
            else if (lb.get(i).getText().contains("Size")) {
                WebElement sizeDropdown = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/select"));
                new Select(sizeDropdown).selectByIndex(2);
            }
            else if (lb.get(i).getText().contains("Print")) {
                WebElement printSelect = lb.get(i).findElement(By.xpath("((//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "//span/span)[2]"));
                printSelect.click();

            }
            else if (lb.get(i).getText().contains("Enter your text:")) {
                WebElement inputText = lb.get(i).findElement(By.xpath("(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/input"));
                inputText.sendKeys("My T-Shirt");
            }


        }


//            switch (label.getText()){
//                case " Processor " :
//                    WebElement processorDropdown = label.findElement(dropdown);
//                    new Select(processorDropdown).selectByIndex(1);
//
//                case " RAM " :
//                    WebElement ramDropdown = label.findElement(dropdown);
//                    new Select(ramDropdown).selectByIndex(1);
//
//            }
    }
    }



