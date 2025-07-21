package downloadFile;

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

public class DownloadFileTest {
    
    private WebDriver driver;
    private String downloadFilePath="C:\\Users\\Equipo\\Downloads\\test";
    private String secondElement = "//a[2]";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();

        HashMap<String, Object> chromePrefrs = new HashMap<String, Object>();
        chromePrefrs.put("profile.default_content_settings.popup", 0);
        chromePrefrs.put("download.default_directory", downloadFilePath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefrs);

        driver = new ChromeDriver(options);

    } 

    @Test
    public void downloadFile() throws InterruptedException{      
        driver.get("https://the-internet.herokuapp.com/download");
        driver.manage().window().maximize(); 

        driver.findElement(By.xpath(secondElement)).click();
        Thread.sleep(2000);

        File folder = new File(downloadFilePath);
        File [] listFiles = folder.listFiles();
        assertTrue("File not download", listFiles.length>0);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
