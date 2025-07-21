package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageContactUs {
    
    private String btnContacUs = "//a[@title='Contact us']";
    private String cbxTitle = "//select[@id='id_contact']";
    private String inpEmail = "//input[@id='email']";
    private String inpOrderNum = "//input[@id='id_order']";
    private String btnSend = "//span[normalize-space()='Send']";
    private String txaMessage = "//textarea[@id='message']";
    private String messageSucces = "//p[@class='alert alert-success']";
    
    private WebDriver driver;
    private WebDriverWait wait;

    public PageContactUs(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    public void selectTittle(String tittle){
        WebElement selectTitle = driver.findElement(By.xpath(cbxTitle));
        Select selectWeb = new Select(selectTitle);
        selectWeb.selectByVisibleText(tittle);
    }

    public void enterEmail(String email){
        WebElement emailElement = driver.findElement(By.xpath(inpEmail));
        emailElement.sendKeys(email);
    }

    public void enterOrder(String order){
        WebElement orderNum = driver.findElement(By.xpath(inpOrderNum));
        orderNum.sendKeys(order);
    }

    public void enterMessage(String message){
        WebElement messageElement = driver.findElement(By.xpath(txaMessage));
        messageElement.sendKeys(message);
    }

    public void sendRequest(){
        WebElement  send = driver.findElement(By.xpath(btnSend));
        send.click();
    }

    public void validationTittle(String expectedText){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(messageSucces)));
        String succes = driver.findElement(By.xpath(messageSucces)).getText();
        String excepted = expectedText;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertTrue(succes.contains(excepted));
    }

    public void test(){
        driver.findElement(By.xpath(btnContacUs)).click();
    }

}
