package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePage.BasePage;
import utils.WaitUtil;

import java.util.List;
import java.util.Random;

public class ProductsCategoryPage extends BasePage {
    WebDriver driver;

    public ProductsCategoryPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1")
    private WebElement productDetailHeading;

    @FindBy(xpath = "//h2/a")
    List<WebElement> productsTitle;



    public String getProductPageTitle()  {
//        WaitUtil.pageLoadWait();
        WaitUtil.explicitWait(productDetailHeading);
        return productDetailHeading.getText();
    }

    public void productTitleClick(){
        productsTitle.get(new Random().nextInt(productsTitle.size())).click();
    }


//    public void addToCart(){
//        addToCartButtons.get(new Random().nextInt(addToCartButtons.size())).click();
//    }

}
