package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageMercadoLibre {

    private String elementsList = "//ol//li[@class='ui-search-layout__item shops__layout-item']";
    private String searchBar = "//input[@id='cb1-edit']";
    private String buttonSearch = "//div[@aria-label='Buscar']";
    private String priceElements = "//div[@class='poly-price__current']//span[@class='andes-money-amount__fraction']";
    private String nameElemets = "//a[@class='poly-component__title']";

    private WebDriver driver;
    private Random rand = new Random();
    private int selectElementList=0;
    

    public PageMercadoLibre(WebDriver driver){
        this.driver=driver;
    }

    public void enterCriteriaSearch(String criteria){
        WebElement search = driver.findElement(By.xpath(searchBar));
        search.sendKeys(criteria);
        search.sendKeys(Keys.ENTER);
    }

    public List<WebElement> selectElementsList(){
        List<WebElement> results = driver.findElements(By.xpath(elementsList));
        return results;
    }

    public String nameElementList(){
        
        List<WebElement> resultsName = driver.findElements(By.xpath(nameElemets));
        selectElementList = rand.nextInt(resultsName.size());
        WebElement randomElementName = resultsName.get(selectElementList);

        String expectedName = randomElementName.getText();
        return expectedName;
    }

    public String priceElementList(){
        List<WebElement> resultsPrice = driver.findElements(By.xpath(priceElements));
        WebElement randomElementPrice = resultsPrice.get(selectElementList);

        String expectedPrice = randomElementPrice.getText();
        return expectedPrice;
    }

    public void seletcElementListSearch(){
        List<WebElement> resultsName = driver.findElements(By.xpath(nameElemets));
        WebElement randomElementName = resultsName.get(selectElementList);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", randomElementName);

        randomElementName.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    public void listPrice(){
        List<WebElement> results = driver.findElements(By.xpath(priceElements));
        for(WebElement result : results){
            System.out.println("El precio es: " + result.getText());
        }
    }

    public void listName(){
        List<WebElement> results = driver.findElements(By.xpath(nameElemets));
        for(WebElement result : results){
            System.out.println("El nombre es: " + result.getText());
        }
    }

    public void search(){
        WebElement button = driver.findElement(By.xpath(buttonSearch));
        button.click();
    }
    
}
