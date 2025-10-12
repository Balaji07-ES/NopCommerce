package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.ProductsCategoryPage;
import pageObjects.SearchPage;

public class SearchTest extends BaseTest {
    SearchPage searchPage;
    ProductsCategoryPage productsCategoryPage;

    @BeforeClass
    public void searchSetup(){
        searchPage = pageObjectManager.getSearchpage();
        productsCategoryPage =pageObjectManager.getProductsCategoryPage();
    }

    @Test(priority = 2)
    public void fieldsDisplayed(){
        Assert.assertTrue(searchPage.isSearchBoxDisplayed());
        Assert.assertTrue(searchPage.isSearchBoxDisplayed());
        searchPage.searchText("app");
        Assert.assertTrue(searchPage.isSearchDropdownDisplayed(),"Search Dropdown is not being loaded");
    }

    @Test(priority = 1)
    public void labelsTest(){
        Assert.assertEquals(searchPage.getSearchText("apple"),"apple");
        Assert.assertEquals(searchPage.getSearchButtonText(),"SEARCH");
        Assert.assertEquals(searchPage.getSearchPlaceHolder(),"Search store");
    }

    @Test(priority = 3,dataProvider = "Searching Words")
    public void searchDropdownTest(String keyword){
        searchPage.searchText(keyword);
        Assert.assertTrue(searchPage.isSearchedTextDisplayed(),"Searched Word "+keyword +" is not Present" + " | Exception->>" + searchPage.getDropdownException());
    }

    @Test(priority = 4)
    public void emptySearchTest(){
        searchPage.clearSearchBox();
        searchPage.clickSearchButton();
        Assert.assertEquals(searchPage.closeSearchPopups(),"Please enter some search keyword");
    }

    @Test (priority = 5, dataProvider = "Searching Words")
    public void searchResultsTest(String keyword) {
        searchPage.searchText(keyword);
        String clickedProduct = searchPage.dropdownItemsClick();
        String productTitle = productsCategoryPage.getProductPageTitle();
        Assert.assertEquals(clickedProduct,productTitle);
    }

    @Test(priority = 6, dataProvider = "Searching Words")
    public void searchResultTest(String keyword) throws InterruptedException {
        searchPage.searchText(keyword);
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isSearchTitleDisplayed());
        Assert.assertEquals(searchPage.getSearchTitleText(),"Search");
        Assert.assertTrue(searchPage.getSearchResults(keyword));
    }

    @Test(priority = 7)
    public void emptySearchResultsTest(){
        searchPage.searchText("dell");
        searchPage.clickSearchButton();
        Assert.assertTrue(searchPage.isNoResultDisplayed());
        Assert.assertEquals(searchPage.getNoResultText(),"No products were found that matched your criteria.");

    }

    @DataProvider(name = "Searching Words")
    public Object[][] searchWords(){
        return new Object[][] {{"book"},{"dell"},{"laptop"},{"necklace"}};
    }

}
