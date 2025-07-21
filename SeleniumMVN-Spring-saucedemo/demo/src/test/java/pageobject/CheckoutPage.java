package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constantsglobal.ConstantsGeneral;

public class CheckoutPage extends Base{

    private By titleCheckoutValidation = By.xpath(ConstantsGeneral.TITLE_CHECKOUT_VALIDATION);
    private By inpFirstName = By.xpath(ConstantsGeneral.INPUT_FIRSTNAME);
    private By inpLastName = By.xpath(ConstantsGeneral.INPUT_LASTNAME);
    private By inpPostalCode = By.xpath(ConstantsGeneral.INPUT_POSTALCODE);
    private By btnContinue = By.xpath(ConstantsGeneral.BUTTON_CONTINUE);

    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    public String titleValidation(){
        String text = getText(titleCheckoutValidation);
        return text;
    }

    public void enterFirstName(String firstname){
        insertValue(inpFirstName, firstname);
    }
    
    public void enterLastname(String lastname){
        insertValue(inpLastName, lastname);
    }

    public void enterPostalCode(String postalcode){
        insertValue(inpPostalCode, postalcode);
    }

    public void selectContinue(){
        clickButton(btnContinue);
    }

    public void enterInformation(String firstname, String lastaname, String postalcode){
        enterFirstName(firstname);
        enterLastname(lastaname);
        enterPostalCode(postalcode);
        selectContinue();
    }
}
