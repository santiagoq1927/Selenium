package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {
    
    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver=driver;
    }

    public WebElement finElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void insertValue(By locator, String inputText){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void clickButton(By locator){
        driver.findElement(locator).click();
    }

    public void clickElement(WebElement element){
        element.click();
    }

    public boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isExistElement(By locator){
        if(driver.findElements(locator).size() !=0){
            return driver.findElements(locator).size() !=0;
        }else{
            return false;
        }
    }

    public void visitUrl(String url){
        driver.get(url);
    }
}
