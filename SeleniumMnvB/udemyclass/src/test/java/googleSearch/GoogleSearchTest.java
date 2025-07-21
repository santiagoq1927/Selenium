package googleSearch;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.GooglePage;

public class GoogleSearchTest {

    private WebDriver driver;
    private String txtSearchGoogle = "Test automation";

    @Autowired
    private GooglePage googlePage;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        googlePage = PageFactory.initElements(driver, GooglePage.class);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void searchGoogle(){
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        googlePage.enterSearchText(txtSearchGoogle);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        assertEquals("Test automation - Buscar en Google", driver.getTitle());
    }

    @Rule
    public TestRule watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable throwable, Description description){
            File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            try {
                FileUtils.copyFile(screenshotFile, new File("test_failed" + description.getMethodName() + ".png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description){
            driver.quit();
        }
    };
    
}
