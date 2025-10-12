package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import BasePage.BasePage;
import utils.JavaScriptUtil;
import utils.WaitUtil;

import java.util.List;

public class SearchPage extends BasePage {
    WebDriver driver;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".no-result")
    WebElement noResult;

    @FindBy(xpath = "//h2/a")
    List<WebElement> searchResultsTitle;

    @FindBy(css = ".products-container")
    WebElement productContainer;

    @FindBy(xpath = "//h1")
    WebElement searchTitle;




    public boolean isNoResultDisplayed(){
        JavaScriptUtil.scrollToElement(driver,noResult);
        WaitUtil.explicitWait(noResult);
        return noResult.isDisplayed();
    }
    public String getNoResultText(){
        return noResult.getText();
    }

    public boolean isSearchTitleDisplayed(){
        WaitUtil.explicitWait(searchTitle);
        return searchTitle.isDisplayed();
    }

    public String getSearchTitleText(){
        return searchTitle.getText();
    }




    public boolean getSearchResults(String keyword){
        boolean resultsFound = false;
        try {
            if (searchResultsTitle.getFirst().isDisplayed()){
            JavaScriptUtil.scrollToElement(driver,productContainer);
            WaitUtil.waitAllItems(searchResultsTitle);
//            searchResultsTitle.forEach(n-> System.out.println(n.getText()));
            resultsFound=searchResultsTitle.stream().allMatch(n->n.getText().toLowerCase().contains(keyword));
            return resultsFound;
        }
        } catch (Exception e) {
            resultsFound = isNoResultDisplayed();
            return resultsFound;
        }
        return false;
    }


}
