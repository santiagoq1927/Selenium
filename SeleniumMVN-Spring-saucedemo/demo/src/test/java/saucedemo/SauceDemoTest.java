// package saucedemo;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

// import java.time.Duration;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.By.ByXPath;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.support.PageFactory;
// import org.openqa.selenium.support.ui.ExpectedCondition;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.springframework.beans.factory.annotation.Autowired;

// import constantsglobal.ConstantsGeneral;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import pageobject.LoginPage;

// public class SauceDemoTest {

//     private WebDriver driver;

//     @Autowired
//     private LoginPage loginPage;
    
//     @Before
//     public void setup(){
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         loginPage = PageFactory.initElements(driver,LoginPage.class);
//     }

//     @After
//     public void tearDown(){
//         driver.quit();
//     }

//     @Test
//     public void e2eSuaceDemo(){
//         driver.get("https://www.saucedemo.com/");
//         driver.manage().window().maximize();

//         loginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);

//         // espera implicitas
//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//         //espera explicita
//         WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(5));
//         explicitWait.until(ExpectedConditions.titleContains(ConstantsGeneral.TITTLE));
//         assertEquals(ConstantsGeneral.TITTLE,driver.getTitle());
//         //assertTrue(loginPage.getButtonLogin().isDisplayed());
//     }
    
// }
