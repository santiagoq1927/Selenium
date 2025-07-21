package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage{

    private String inpUserName = "//input[@id='user-name']";
    private String intPassword = "//input[@id='password']";
    private String btnLogin = "//input[@id='login-button']";

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    
    public void enterUserName(String username){
        WebElement textSend = driver.findElement(By.xpath(inpUserName));
        textSend.sendKeys(username);
    }

    public void enterPassword(String password){
        WebElement textSend = driver.findElement(By.xpath(intPassword));
        textSend.sendKeys(password);
    }

    public void selectLogin(){
        WebElement actionSelect = driver.findElement(By.xpath(btnLogin));
        actionSelect.click();
    }

    public void toLogin(String username, String password){
        enterUserName(username);
        enterPassword(password);
        selectLogin();
    }
}
