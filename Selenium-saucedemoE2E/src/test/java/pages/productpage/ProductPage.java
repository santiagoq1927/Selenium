package pages.productpage;

import pages.BasePage;

public class ProductPage extends BasePage{

    private String btnAddCart = "//button[@id='add-to-cart']";
    
    public ProductPage(){
        super(driver);
    }

    public void selectAddCart(){
        clickElement(btnAddCart);
    }


    
}
