package pageObjects;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtil;

public class CheckoutPage  extends BasePage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='BillingNewAddress_StateProvinceId']")
    private WebElement stateDropdown;

    @FindBy(id = "BillingNewAddress_City")
    private WebElement cityInput;

    @FindBy(id = "BillingNewAddress_Address1")
    private WebElement addressInput;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    private WebElement zipCodeInput;

    @FindBy(id = "BillingNewAddress_CountryId")
    private WebElement countryInput;

    @FindBy(xpath = "//div[@id='billing-buttons-container']/button[2]")
    private WebElement addressContinueButton;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
    private WebElement shippingContinueButton;

    @FindBy(xpath = "//div[@id='payment-method-buttons-container']/button")
    private WebElement paymentMethodContinueButton;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']/button")
    private WebElement paymentInfoContinueButton;

    @FindBy(xpath = "//button[text()='Confirm']")
    private WebElement confirmOrderButton;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    private WebElement phoneNumberInput;

    @FindBy(css = ".order-total span")
    private WebElement orderTotalAmount;


    public void selectState() {

        WaitUtil.explicitWait(stateDropdown);
        new Select(stateDropdown).selectByVisibleText("New York");
    }

    public void enterCity(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void enterAddress(String address) {
        addressInput.clear();
        addressInput.sendKeys(address);
    }

    public void enterZipCode(String zipCode) {
        zipCodeInput.clear();
        zipCodeInput.sendKeys(zipCode);
    }

    public void enterCountry(String country) {
        countryInput.clear();
        countryInput.sendKeys(country);
    }

    public void enterPhoneNumber(String phoneNumber) {

        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void addressContinueButton() {
        WaitUtil.explicitWait(addressContinueButton);
        addressContinueButton.click();
    }

    public void shippingContinueButton()    {
        WaitUtil.explicitWait(shippingContinueButton);
        shippingContinueButton.click();
    }

    public void paymentContinueButton(){
        WaitUtil.explicitWait(paymentMethodContinueButton);
        paymentMethodContinueButton.click();
    }

    public void paymentInfoContinueButton(){
        WaitUtil.explicitWait(paymentInfoContinueButton);
        paymentInfoContinueButton.click();
    }

    public void confirmOrderButton(){
        WaitUtil.explicitWait(confirmOrderButton);
        confirmOrderButton.click();
    }

    public String getOrderTotalAmountText(){
        return orderTotalAmount.getText();
    }


}
