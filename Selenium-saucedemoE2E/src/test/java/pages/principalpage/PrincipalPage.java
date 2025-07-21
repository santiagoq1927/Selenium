package pages.principalpage;

import pages.BasePage;

public class PrincipalPage extends BasePage{

    private String txtNameStore = "//div[@class='app_logo']";
    private String selFirstElement = "//div[@data-test='inventory-item'][1]//a[@data-test='item-4-title-link']";
    private String btnBuyCart = "//div[@id='shopping_cart_container']";

    public PrincipalPage(){
        super(driver);
    }

    public String textNamePage(){
        String text = textElement(txtNameStore);
        return text;
    }

    public void selectFirstElement(){
        clickElement(selFirstElement);
    }

    public void selectBuyCart(){
        clickElement(btnBuyCart);
    }
    
}
