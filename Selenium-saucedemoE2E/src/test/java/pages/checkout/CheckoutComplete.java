package pages.checkout;

import pages.BasePage;

public class CheckoutComplete extends BasePage{

    private String txtFinish = "//h2[@data-test='complete-header']";
    private String txtComplete = "//span[@data-test='title']";

    public CheckoutComplete(){
        super(driver);
    }
    
    public String textFinish(){
        String text = textElement(txtFinish);
        return text;
    }

    public String textComplete(){
        String text = textElement(txtComplete);
        return text;
    }


}
