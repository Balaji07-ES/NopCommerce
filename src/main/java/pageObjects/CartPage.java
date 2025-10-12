package pageObjects;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashMap;
import java.util.List;

public class CartPage extends BasePage {
    WebDriver driver;
    LinkedHashMap<String, String> cartMap;

    public CartPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//table[@class='cart']//a[@class='product-name']")
    private List<WebElement> productsTitle;

    @FindBy(xpath = "//table[@class='cart']")
    private WebElement cartTable;

    @FindBy(xpath = "//table[@class='cart']//tbody/tr")
    private List<WebElement> rows;

    @FindBy(css = ".terms-of-service input")
    private WebElement termsOfServiceCheckbox;

    @FindBy(css = ".checkout-buttons button")
    private WebElement checkoutButton;

    @FindBy(css = ".message-error")
    private WebElement recurringErrorMessage;



    By skuCol = By.xpath("./td[1]");
    By productCol = By.xpath("./td[3]");
    By priceCol = By.xpath("./td[4]");
    By qtyCol = By.xpath("./td[5]//input");
    By totalCol = By.xpath("./td[6]");
    By removeCol = By.xpath("./td[7]//input");




    public LinkedHashMap<String, String> getCartTable(){
        cartMap = new LinkedHashMap<>();
        for (int i=0;i<rows.size();i++) {
            String sku = rows.get(i).findElement(skuCol).getText();
            String product = rows.get(i).findElement(productCol).getText();
            String price = rows.get(i).findElement(priceCol).getText();
            String qty = rows.get(i).findElement(qtyCol).getAttribute("value");
            String total = rows.get(i).findElement(totalCol).getText();
            cartMap.put("product"+(i+1),product);
            cartMap.put("skuIDOfProduct"+(i+1),sku);
            cartMap.put("priceOfProduct"+(i+1),price);
            cartMap.put("qtyOfProduct"+(i+1),qty);
            cartMap.put("totalPriceOfProduct"+(i+1),total);
        }
        return cartMap;
    }

    public void checkTermsOfService(){
        if (!termsOfServiceCheckbox.isSelected()){
            termsOfServiceCheckbox.click();
        }
    }
    public void clickCheckout(){
        checkoutButton.click();
    }
    
    public void removeRecurringProduct(){

        try {
            if (cartMap.get("product1").contains("(recurring)")){
                rows.get(0).findElement(removeCol).click();
                System.out.println("recurring product removed");

            }
        } catch (Exception e) {
            System.out.println("No recurring product to remove");
        }
        
    }



}
