package pages.checkout;

import pages.BasePage;

public class CheckoutInformationPage extends BasePage{

    private String inpFistName = "//input[@id='first-name']";
    private String inpLastName = "//input[@id='last-name']";
    private String inpPostalCode = "//input[@id='postal-code']";
    private String btnContinue = "//input[@id='continue']";

    public CheckoutInformationPage(){
        super(driver);
    }

    public void enterFirstName(String fistname){
        write(inpFistName, fistname);
    }

    public void enterLastName(String lastname){
        write(inpLastName, lastname);
    }

    public void enterPostalConde(String postalcode){
        write(inpPostalCode, postalcode);
    }

    public void selectContinue(){
        clickElement(btnContinue);
    }

    public void enterInformation(String firstname, String lastname, String postalcode){
        enterFirstName(firstname);
        enterLastName(lastname);
        enterPostalConde(postalcode);
        selectContinue();
    }
    
}
