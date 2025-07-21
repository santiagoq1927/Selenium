package uploadFile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFileTest {

    private WebDriver driver;
    private String btnSelectFile="//input[@id='file-upload']";
    private String btnUpload = "//input[@id='file-submit']";
    private String txtNameFile = "//div[@id='uploaded-files']";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    } 

    @Test
    public void downloadFile() throws InterruptedException{      
        File file = new File("C:\\Users\\Equipo\\Downloads\\automationBase\\test.txt");
        String path = file.getAbsolutePath();

        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize(); 

        driver.findElement(By.xpath(btnSelectFile)).sendKeys(path);
        driver.findElement(By.xpath(btnUpload)).click();
        String nameFile = driver.findElement(By.xpath(txtNameFile)).getText();
        assertEquals("test.txt", nameFile);
        Thread.sleep(2000);
        
    }

    @After
    public void tearDown(){
        driver.quit();
    }
    
}
