package BasePage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ActionsUtil;
import utils.WaitUtil;

import java.util.List;
import java.util.Random;

public class BasePage {
    private WebDriver driver;

    private String dropdownException = null;

    private String searchText =null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    @FindBy(xpath = "//a[text()='Log in']")
    protected WebElement loginLink;

    @FindBy(xpath = "//a[text()='Register']")
    protected WebElement registerLink;

    @FindBy(css = ".ico-account")
    protected WebElement myAccountLink;

    @FindBy(css=".ico-logout")
    protected WebElement logoutLink;

    @FindBy (css = "input[placeholder='Search store']")
    protected WebElement searchBox;

    @FindBy (css = ".search-box-button")
    protected WebElement searchButton;

    @FindBy(css = ".ui-widget-content.ui-autocomplete")
    protected WebElement searchDropdown;

    @FindBy(css = ".ui-menu-item a span")
    protected List<WebElement> dropdownList;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[1]")
    protected WebElement computerLink;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[2]")
    protected WebElement electronicsLink;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[3]")
    protected WebElement apparelLink;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[4]")
    protected WebElement digitalDownloads;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[5]")
    protected WebElement booksLink;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[6]")
    protected WebElement jewelryLink;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[7]")
    protected WebElement giftCardsLink;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[1]/ul/li")
    protected List<WebElement> computerDropdown;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[2]/ul/li")
    protected List<WebElement> electronicsDropdown;

    @FindBy(xpath = "//ul[contains(@class,'top-menu')]/li[3]/ul/li")
    protected  List<WebElement> apparelDropdown;

    @FindBy(xpath = "//div[@class='header-links']//li[4]")
    protected WebElement cartIcon;



    public void navigateToLoginPage() {
        WaitUtil.explicitWait(loginLink);
        loginLink.click();
    }

    public void navigateToRegisterPage() {
        registerLink.click();
    }

    public boolean isMyAccountLinkDisplayed(){
        return myAccountLink.isDisplayed();
    }

    public boolean isLogoutLinkDisplayed(){
        return logoutLink.isDisplayed();
    }

    public void logOutClick(){
        WaitUtil.explicitWait(logoutLink);
        logoutLink.click();
    }

    public boolean isSearchBoxDisplayed(){
        return searchBox.isDisplayed();
    }

    public boolean isSearchButtonDisplayed(){
        return searchButton.isDisplayed();
    }

    public String getSearchText(String text){
        searchText(text);
        return searchBox.getAttribute("value") ;
    }

    public String getSearchButtonText(){
        return searchButton.getText();
    }

    public String getSearchPlaceHolder(){
        return  searchBox.getAttribute("placeholder");
    }
    public void searchText(String keyword){
        WaitUtil.explicitWait(searchBox);
        this.searchText = keyword;
        searchBox.clear();
        searchBox.sendKeys(keyword);
    }

    public boolean isSearchDropdownDisplayed(){
        try {
            WaitUtil.explicitWait(searchDropdown);
            return searchDropdown.isDisplayed();
        }
        catch (NullPointerException e) {
            return false;
        }
    }

    public boolean isSearchedTextDisplayed() {
        boolean wordPresent =false;
        try {
            if (isSearchDropdownDisplayed())
                 wordPresent= dropdownList.stream()
                        .allMatch(item -> item.getText().toLowerCase().contains(searchText.toLowerCase()));
                 return wordPresent;

        }
        catch (Exception e) {
            dropdownException = e.getClass().getName();
            return false;
        }
    }

    public String getDropdownException(){
        return dropdownException;
    }

    public void clearSearchBox(){
        WaitUtil.explicitWait(searchBox);
        searchBox.clear();
    }

    public void clickSearchButton(){
        WaitUtil.explicitWait(searchBox);
        searchButton.click();
    }

    public String closeSearchPopups(){
        WaitUtil.alertExplicitWait();
        Alert searchPopup= driver.switchTo().alert();
        String alertText = searchPopup.getText();
//        System.out.println("From actions method ->>"+alertText);
        searchPopup.accept();
        driver.switchTo().defaultContent();
        return alertText;
    }

    public String dropdownItemsClick() {
        String itemText =null;
         try {
             WaitUtil.explicitWait(searchDropdown);
             WaitUtil.waitAllItems(dropdownList);
             WebElement selectedProduct = dropdownList.get(new Random().nextInt(dropdownList.size()));
                 itemText = selectedProduct.getText();
                 if (selectedProduct.isEnabled()) {
                     selectedProduct.click();
                 }
                 return itemText;
         }catch (Exception e){
             itemText = e.getClass().getSimpleName();
         }

        return itemText;
    }

    public void computerClick(){
        ActionsUtil.howeverState(driver, computerLink);
        computerDropdown.get(new Random().nextInt(3)).click();
    }
    public void electronicsClick(){
        ActionsUtil.howeverState(driver, electronicsLink);
        electronicsDropdown.get(new Random().nextInt(3)).click();
    }

    public void apparelClick(){
        ActionsUtil.howeverState(driver, apparelLink);
        apparelDropdown.get(new Random().nextInt(3)).click();
    }

    public void cartIconClick() throws InterruptedException {
        Thread.sleep(2000);
        cartIcon.click();
    }

    public void digitalDownloadsClick() throws InterruptedException {
        Thread.sleep(2000);
        digitalDownloads.click();
    }
    public void booksClick() throws InterruptedException {
        Thread.sleep(2000);
        booksLink.click();
    }
    public void jewelryClick() throws InterruptedException {
        Thread.sleep(2000);
        jewelryLink.click();
    }
    public void giftCardsClick() throws InterruptedException {
        Thread.sleep(2000);
        giftCardsLink.click();
    }



}
