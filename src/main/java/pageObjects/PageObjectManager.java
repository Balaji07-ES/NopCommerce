package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    WebDriver driver;
    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }
    private LoginPage loginPage;
    private RegisterPage registerPage;

    public LoginPage getLoginPage(){
        return (loginPage==null)? loginPage=new LoginPage(driver):loginPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage==null)? registerPage=new RegisterPage(driver):registerPage;
    }
}
