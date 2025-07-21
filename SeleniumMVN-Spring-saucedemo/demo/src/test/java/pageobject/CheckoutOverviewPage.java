package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constantsglobal.ConstantsGeneral;

public class CheckoutOverviewPage extends Base{

    private By titleCheckoutOverview = By.xpath(ConstantsGeneral.TITLE_CHECKOUT_VALIDATION);
    private By btnFinish = By.xpath(ConstantsGeneral.BUTTON_FINISH);

    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    public String titleCheckoutOverview(){
        String title = getText(titleCheckoutOverview);
        return title;
    }

    public void selectFinish(){
        clickButton(btnFinish);
    }
    
}
