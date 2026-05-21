package utilities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class CommonFlows {
    private WebDriver getDriver(){
        return new WebDriverProvider().get();
    }

    public void goLoginPage(){
        getDriver().get("https://www.saucedemo.com/");
        new LoginPage().waitPageToLoad();
    }

    public void goHomePage(){
        goLoginPage();
        new LoginPage().login("standard_user","secret_sauce");
        new HomePage().waitPageToLoad();
    }

    public void goDetailProduct(String name){
        goHomePage();
        new HomePage().selectProduct(name);
        new DetailProductPage().waitPageToLoad();
    }

    public void goCart(){
        goHomePage();
        new TopBarPage().selectCart();
        new CartPage().waitPageToLoad();
    }

    public void goInformationPage(){
        goCart();
        new CartPage().selectCheckout();
        new InformationPage().waitPageToLoad();
    }
}
