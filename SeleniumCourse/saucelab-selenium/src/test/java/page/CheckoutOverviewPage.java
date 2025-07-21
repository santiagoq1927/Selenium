package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private String txtNameproductOverview="//div[@data-test='inventory-item-name']";
    private String txtPriceproductOverview="//div[@data-test='inventory-item-price']";
    private String txtPriceItemTotal = "//div[@data-test='subtotal-label']";
    private String txtPriceTax = "//div[@data-test='tax-label']";
    private String txtPriceTotal = "//div[@data-test='total-label']";

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }

    public String textNameproductOverview(int index){
        List<WebElement> elements = driver.findElements(By.xpath(txtNameproductOverview));
        String text = elements.get(index).getText();
        return text;
    }

    public String textPriceproductOverview(int index){
        List<WebElement> elements = driver.findElements(By.xpath(txtPriceproductOverview));
        String text = elements.get(index).getText();
        return text;
    }

    public Double numericPriceProduct(int index){
        List<WebElement> results = driver.findElements(By.xpath((txtPriceproductOverview)));
        //String textCleaning = results.get(index).getText().replaceAll("[^\\d']", "");
        String textClean = results.get(index).getText().substring(1);
        double priceNumeric = Double.parseDouble(textClean);
        return priceNumeric;
    }

    public Double numericPriceItemTotal(){
        WebElement element = driver.findElement(By.xpath(txtPriceItemTotal));
        String text = element.getText().substring(13);
        double priceNumeric = Double.parseDouble(text);
        return priceNumeric;
    }

    public Double numericPriceTax(){
        WebElement element = driver.findElement(By.xpath(txtPriceTax));
        String text = element.getText().substring(6);
        double priceNumeric = Double.parseDouble(text);
        return priceNumeric;
    }

    public Double numericPriceTotal(){
        WebElement element = driver.findElement(By.xpath(txtPriceTotal));
        String text = element.getText().substring(8);
        double priceNumeric = Double.parseDouble(text);
        return priceNumeric;
    }
}
