package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constantsglobal.ConstantsGeneral;

public class SauceInitialPage extends Base{

    private By textProduct = By.xpath(ConstantsGeneral.TEXT_PRODUCT);
    private By selectFilterElement = By.xpath(ConstantsGeneral.SELECT_FILTER_PRODUCTS);
    private By selectOptionFilter = By.xpath(ConstantsGeneral.OPTION_FILTER_PRODUCTS);

    private By firstProduct = By.xpath(ConstantsGeneral.FIRST_PRODUCT);
    private By secondProduct = By.xpath(ConstantsGeneral.SECOND_PRODUCT);
    private By thirdProduct = By.xpath(ConstantsGeneral.THIRD_PRODUCT);

    private By cartProduct = By.xpath(ConstantsGeneral.CART_PRODUCT);
    
    
    public SauceInitialPage(WebDriver driver){
        super(driver);
    }

    public String textProductTitle(){
        String text = getText(textProduct);
        return text;
    }

    public void selectFilterOption(int index){
        selectForIndex(selectFilterElement, index);
    }

    public void selectFilterValue(String value){
        selectForValue(selectFilterElement, value);
    }

    public String textOpcionSelect(){
        String text = getText(selectOptionFilter);
        return text;
    }
    
    public void selectAddProductCart(){
        clickButton(firstProduct);
        clickButton(secondProduct);
        clickButton(thirdProduct);
    }

    public void selectCart(){
        clickButton(cartProduct);
    }
}
