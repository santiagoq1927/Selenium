package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constantsglobal.ConstantsGeneral;

public class CheckoutCompletePage extends Base{

    private By titleCheckoutComplete = By.xpath(ConstantsGeneral.TITLE_CHECKOUT_COMPLETE);
    private By btnBackHome = By.xpath(ConstantsGeneral.BUTTON_BACKHOME);

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
    }

    public String titleCheckoutComplete(){
        String title = getText(titleCheckoutComplete);
        return title;
    }

    public void selectBackHome(){
        clickButton(btnBackHome);
    }
    
    
}
