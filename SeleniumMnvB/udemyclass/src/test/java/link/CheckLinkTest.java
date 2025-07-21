package link;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckLinkTest {
    
    private WebDriver driver;
    private CheckLinkPage checkLinkPage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        checkLinkPage = new CheckLinkPage(driver);
        
    } 

    @Test
    public void checkPageUrl(){      
        driver.get("https://www.bbc.com/");
        driver.manage().window().maximize(); 
        assertTrue(checkLinkPage.checkPageLink());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}


