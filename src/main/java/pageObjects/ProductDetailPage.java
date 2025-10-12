package pageObjects;

import BasePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.JavaScriptUtil;
import utils.WaitUtil;

import java.util.List;

public class ProductDetailPage extends BasePage {
    WebDriver driver;

    public ProductDetailPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1")
    private WebElement productTitle;

    @FindBy(css = ".add-to-cart-panel button")
    private WebElement addToCartButton;

    @FindBy(css = ".sku span[class='value']")
    private WebElement sku;

    @FindBy(css = ".product-price")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@class='add-to-cart-panel']/input")
    private WebElement quantity;

    @FindBy(css = ".bar-notification.success")
    private WebElement successPopup;

    @FindBy(css = ".bar-notification.success span")
    private WebElement successPopupClose;

    @FindBy(xpath = "//label[@class='text-prompt']")
    private List<WebElement> attributesLabel;

    @FindBy(xpath = "//dt")
    private List<WebElement> mandatoryFields;

    @FindBy(xpath = "(//div[@class='attribute-data'])[1]")
    private WebElement startDateInput;

    @FindBy(xpath = "(//div[@class='attribute-data'])[2]")
    private WebElement EndDateInput;

    @FindBy(css = ".ui-datepicker-calendar")
    private WebElement datePicker;

    @FindBy(xpath = "(//td[a])[27]")
    private WebElement startDate;

    @FindBy(xpath = "(//td[a])[28]")
    private WebElement endDate;

    @FindBy(xpath = "//button[text()='Rent']")
    private WebElement rentButton;

    @FindBy(css = ".price-input input")
    private WebElement priceInput;

    @FindBy(css = ".recipient-name")
    private WebElement recipientNameInput;

    @FindBy(css = ".sender-name")
    private WebElement yourNameInput;

    @FindBy (css = ".sender-email")
    private WebElement senderEmailInput;

    @FindBy(css = ".recipient-email")
    private WebElement recipientEmailInput;




    //dynamic xpath methods for mandatory Fields

    private WebElement getDropdownElement(int i){
        String xpathValue = "(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/select";
        return driver.findElement(By.xpath(xpathValue));
    }
    private WebElement getCheckboxElement(int i){
        String xpathValue = "(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/ul/li[2]/input";
        return driver.findElement(By.xpath(xpathValue));
    }
    private WebElement getColorPickerElement(int i){
        String xpathValue = "(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/ul/li[2]/label";
        return driver.findElement(By.xpath(xpathValue));
    }
    private WebElement getPrintElement(int i){
        String xpathValue = "((//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "//span/span)[2]";
        return driver.findElement(By.xpath(xpathValue));
    }

    private WebElement getTextInputElement(int i){
        String xpathValue = "(//dt/following-sibling::dd)" + "[" + (i + 1) + "]" + "/input";
        return driver.findElement(By.xpath(xpathValue));
    }


    public String getProductTitle(){
        WaitUtil.explicitWait(productTitle);
        return productTitle.getText();
    }

    public String getSku(){
        return sku.getText();
    }

    public String getProductPrice(){
        try {
            return priceInput.getAttribute("value");
        } catch (Exception e) {
            return productPrice.getText();
        }
    }

    public String getQuantity(){
        return quantity.getAttribute("value");
    }


    public void addToCartClickWithFillMandatory(){
        try {
            fillMandatoryFields();
        }catch (Exception e) {
            JavaScriptUtil.scrollToElement(driver, addToCartButton);
            addToCartButton.click();
        }
    }

    public String getSuccessPopText(){
        WaitUtil.explicitWait(successPopup);
        return successPopup.isDisplayed()?successPopup.getText():null;
    }

    public void closeSuccessPopup(){
        successPopupClose.click();
    }

    public void fillMandatoryFields(){
        for (int i = 0; i < mandatoryFields.size(); i++) {
            if (mandatoryFields.get(i).getText().contains("Processor")) {
                WebElement processorDropdown = getDropdownElement(i);
                new Select(processorDropdown).selectByIndex(2);
            }
            else if (mandatoryFields.get(i).getText().contains("RAM")) {
                WebElement ramDropdown = getDropdownElement(i);
                new Select(ramDropdown).selectByIndex(2);
            }
            else if (mandatoryFields.get(i).getText().contains("HDD")) {
                WebElement radioBoxHDD = getCheckboxElement(i);
                radioBoxHDD.click();
            }
            else if (mandatoryFields.get(i).getText().contains("OS")) {
                WebElement radioBoxOS = getCheckboxElement(i);
                radioBoxOS.click();

            }
            else if (mandatoryFields.get(i).getText().contains("Software")) {
                WebElement checkboxSoftware = getCheckboxElement(i);
                checkboxSoftware.click();
            }
            else if (mandatoryFields.get(i).getText().contains("Color")) {
                try {
                    WebElement colorPicker = getColorPickerElement(i);
                    colorPicker.click();
                } catch (Exception e) {
                    WebElement colorDropdown = getDropdownElement(i);
                    new Select(colorDropdown).selectByIndex(2);
                }


            }
            else if (mandatoryFields.get(i).getText().contains("Size")) {
                WebElement sizeDropdown = getDropdownElement(i);
                new Select(sizeDropdown).selectByIndex(2);
            }
            else if (mandatoryFields.get(i).getText().contains("Print")) {
                WebElement printSelect = getPrintElement(i);
                printSelect.click();

            }
            else if (mandatoryFields.get(i).getText().contains("Enter your text:")) {
                WebElement inputText = getTextInputElement(i);
                inputText.sendKeys("My T-Shirt");
            }

        }
        JavaScriptUtil.scrollToElement(driver,addToCartButton);
        addToCartButton.click();
    }

    public void jewelryAddToCartClick(){
        WaitUtil.explicitWait(productTitle);
        try {
            JavaScriptUtil.scrollToElement(driver,startDateInput);
            startDateInput.click();
            WaitUtil.explicitWait(datePicker);
            startDate.click();
            EndDateInput.click();
            WaitUtil.explicitWait(datePicker);
            endDate.click();
            rentButton.click();
        } catch (Exception e) {
            WaitUtil.explicitWait(addToCartButton);
            JavaScriptUtil.scrollToElement(driver,addToCartButton);
            addToCartButton.click();
        }
    }

    public void addToCartClick(){
        addToCartButton.click();
    }

    public void giftCardAddToCartClick(String recipientName, String yourName){
            try {
                senderEmailInput.sendKeys("abc@gmail.com");
                recipientEmailInput.sendKeys("bcs@gmail.com");
            } catch (Exception e) {
                System.out.println("No email field present");
            }
            recipientNameInput.clear();
            recipientNameInput.sendKeys(recipientName);
            yourNameInput.clear();
            yourNameInput.sendKeys(yourName);
            addToCartButton.click();
    }








}
