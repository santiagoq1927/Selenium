package pages.checkout;

import pages.BasePage;

public class CheckoutOverviewPage extends BasePage{

    private String btnFinish = "//button[@id='finish']";

    public CheckoutOverviewPage(){
        super(driver);
    }

    public void selectFinish(){
        clickElement(btnFinish);
    }
    
}
