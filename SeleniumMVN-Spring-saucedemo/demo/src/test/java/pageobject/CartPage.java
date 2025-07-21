package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constantsglobal.ConstantsGeneral;

public class CartPage extends Base{

    private By titleCartValidation = By.xpath(ConstantsGeneral.TITLE_CART_VALIDATION);
    private By btnCheckout = By.xpath(ConstantsGeneral.BUTTON_CHECKOUT);

    public CartPage(WebDriver driver){
        super(driver);
    }

    public String titleValidation(){
        String text = getText(titleCartValidation);
        return text;
    }

    public void selectCheckout(){
        clickButton(btnCheckout);
    }


    
}
