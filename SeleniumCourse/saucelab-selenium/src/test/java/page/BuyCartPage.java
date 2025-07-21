package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyCartPage {

    private String txtNameProductBuyCart="//div[@data-test='inventory-item-name']";
    private String txtPriceProductBuyCart="//div[@data-test='inventory-item-price']";
    private String btnCheckout="//button[@id='checkout']";

    private WebDriver driver;

    public BuyCartPage(WebDriver driver){
        this.driver = driver;
    }

    public String textNameProductBuyCart(int index){
        List<WebElement> elements = driver.findElements(By.xpath(txtNameProductBuyCart));
        String text = elements.get(index).getText();
        return text;
    }

    public String textPriceProductBuyCart(int index){
        List<WebElement> elements = driver.findElements(By.xpath(txtPriceProductBuyCart));
        String text = elements.get(index).getText();
        return text;
    }

    public void selectCheckout(){
        WebElement element = driver.findElement(By.xpath(btnCheckout));
        element.click();
    }

    
    
}
