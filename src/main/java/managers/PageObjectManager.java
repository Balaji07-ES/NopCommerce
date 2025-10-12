package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {
    WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private ForgotPasswordPage forgotPasswordPage;
    private SearchPage searchPage;
    private ProductsCategoryPage productsCategoryPage;
    private CartPage cartPage;
    private ProductDetailPage productDetailPage;

    public LoginPage getLoginPage(){
        return (loginPage==null)? loginPage=new LoginPage(driver):loginPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage==null)? registerPage=new RegisterPage(driver):registerPage;
    }

    public ForgotPasswordPage getForgotPasswordPage() {
        return (forgotPasswordPage == null)?new ForgotPasswordPage(driver):forgotPasswordPage;
    }

    public SearchPage getSearchpage(){
        return (searchPage == null)?new SearchPage(driver):searchPage;
    }

    public ProductsCategoryPage getProductsCategoryPage(){
        return (productsCategoryPage == null)?new ProductsCategoryPage(driver): productsCategoryPage;
    }

    public CartPage getCartPage(){
        return (cartPage== null)?new CartPage(driver):cartPage;
    }

    public ProductDetailPage getProductDetailPage(){
        return (productDetailPage== null)?new ProductDetailPage(driver):productDetailPage;
    }
}
