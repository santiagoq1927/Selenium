package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageProducto {

    private String nameResult = "//h1[@class='ui-pdp-title']";
    private String priceResult = "//span[@itemprop='offers']//span[@class='andes-money-amount__fraction']";
    
    private WebDriver driver;

    public PageProducto(WebDriver driver){
        this.driver=driver;
    }

    public String nameProduct(){
        String name = driver.findElement(By.xpath(nameResult)).getText();
        return name;
    }

    public String priceProduct(){
        String price = driver.findElement(By.xpath(priceResult)).getText();
        return price;
    }
    
}
