package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInformationPage {

    private String inpFirstName="//input[@id='first-name']";
    private String inpLastName="//input[@id='last-name']";
    private String inpPostalCode="//input[@id='postal-code']";
    private String btnContinue="//input[@id='continue']";

    private WebDriver driver;

    public CheckoutInformationPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterFistname(String firstname){
        WebElement element = driver.findElement(By.xpath(inpFirstName));
        element.sendKeys(firstname);
    }

    public void enterLastname(String lastname){
        WebElement element = driver.findElement(By.xpath(inpLastName));
        element.sendKeys(lastname);
    }

    public void enterPostalcode(String postalcode){
        WebElement element = driver.findElement(By.xpath(inpPostalCode));
        element.sendKeys(postalcode);
    }

    public void selectContinue(){
        WebElement element = driver.findElement(By.xpath(btnContinue));
        element.click();
    }

    public void enterInfo(String firstname, String lastname, String postalcode){
        enterFistname(firstname);
        enterLastname(lastname);
        enterPostalcode(postalcode);
        selectContinue();
    }
    
}
