package pages.buycart;

import pages.BasePage;

public class BuyCartPage extends BasePage{

    private String btnCheckout = "//button[@id='checkout']";

    public BuyCartPage(){
        super(driver);
    }

    public void selectCheckout(){
        clickElement(btnCheckout);
    }
    
}
