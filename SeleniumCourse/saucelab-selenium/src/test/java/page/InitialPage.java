package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InitialPage {

    private String btnAddCartProduct = "//button[@class='btn btn_primary btn_small btn_inventory ']";
    private String txtNameProduct = "//div[@data-test='inventory-item-name']";
    private String txtPriceProduct = "//div[@data-test='inventory-item-price']";
    private String btnBuyCart = "//div[@id='shopping_cart_container']";

    private WebDriver driver;

    public InitialPage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
    public void selectAnElement(int index){
        List<WebElement> results = driver.findElements(By.xpath(btnAddCartProduct));
        scrollElement(results.get(index));
        results.get(index).click();
    }

    public void selectBuyCart(){
        WebElement cart = driver.findElement(By.xpath(btnBuyCart));
        scrollElement(cart);
        cart.click();
    }

    public String textNameProduct(int index){
        List<WebElement> results = driver.findElements(By.xpath(txtNameProduct));
        String text = results.get(index).getText();
        return text;
    }

    public String textPriceProduct(int index){
        List<WebElement> results = driver.findElements(By.xpath((txtPriceProduct)));
        String text = results.get(index).getText();
        return text;
    }

    public Double numericPriceProduct(int index){
        List<WebElement> results = driver.findElements(By.xpath((txtPriceProduct)));
        //String textCleaning = results.get(index).getText().replaceAll("[^\\d']", "");
        String textClean = results.get(index).getText().substring(1);
        double priceNumeric = Double.parseDouble(textClean);
        return priceNumeric;
    }
}
