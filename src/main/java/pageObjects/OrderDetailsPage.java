package pageObjects;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtil;

public class OrderDetailsPage  extends BasePage {
    WebDriver driver;

    public OrderDetailsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1")
    private WebElement orderCompletedTitle;

    @FindBy(xpath = "(//div[@class='title'])[1]")
    private WebElement thankYouMessage;

    @FindBy(xpath = "//div[@class='details']//strong")
    private WebElement orderNumber;

    @FindBy(xpath = "//div[@class='details-link']/a")
    private WebElement detailsLink;

    @FindBy(css = ".order-total strong")
    private WebElement orderTotalAmount;

    @FindBy(css = " .order-number strong")
    private WebElement orderNum;

    public String getOrderCompletedTitle(){
        WaitUtil.explicitWait(orderCompletedTitle);
        return orderCompletedTitle.getText();
    }
    public String getThankYouMessage(){
        return thankYouMessage.getText();
    }
    public String getOrderNumber(){
        String orderNum= orderNumber.getText();
        String[] orderNumParts= orderNum.split(":");
        return orderNumParts[1];
    }
    public void clickDetailsLink(){
        detailsLink.click();
    }
    public String getOrderTotalAmount(){
        return orderTotalAmount.getText();
    }

    public String getOrderNumFromSummary(){
        return orderNum.getText();
    }

}
