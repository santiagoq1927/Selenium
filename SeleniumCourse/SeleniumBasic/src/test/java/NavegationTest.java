
import java.time.Duration;
import java.time.Instant;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.PageContactUs;
import pages.PageMercadoLibre;
import pages.PageProducto;

public class NavegationTest extends BaseWebTest{

    private String inputEmail = "//input[@id='email']";
    private String inputPass = "//input[@id='pass']";
    private String btnLogin = "//button[@data-testid='royal_login_button']"; 

    private String selectColombia = "//a[@id='CO']";

    private String btnContacUs = "//a[@title='Contact us']";

    /*@Test
    public void navigateToFacebook() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath(inputEmail)).sendKeys("saqano95@gmail.com");
        driver.findElement(By.xpath(inputPass)).sendKeys("yasta");
        driver.findElement(By.xpath(btnLogin)).click();
        Thread.sleep(10000);
    }

    @Test
    public void navigateToMercaLibre() throws InterruptedException {
        driver.get("https://www.mercadolibre.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath(selectColombia)).click();
        String url = driver.getCurrentUrl();
        String urlExcepted = "https://www.mercadolibre.com.co";
        Assert.assertEquals("https://www.mercadolibre.com.co/#from=homecom", url);
        Assert.assertTrue(url.contains(urlExcepted));
        Thread.sleep(3000);
    }

    @Test
    public void navigateToAutomationPractica(){
        PageContactUs pageContactUs = new PageContactUs(driver);
        driver.get("http://www.automationpractice.pl/index.php");
        
        driver.findElement(By.xpath(btnContacUs)).click();
        pageContactUs.selectTittle("Webmaster");
        pageContactUs.enterEmail("email@gmail.com");
        pageContactUs.enterOrder("12345");
        pageContactUs.enterMessage("Hello world");
        pageContactUs.sendRequest();
        
        pageContactUs.validationTittle("Your message has been successfully sent to our team.");
    }

    @Test
    public void navigateToGoogleImplicitWait() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Instant start = Instant.now();

        try {
            driver.findElement(By.xpath("Xpath"));
        } catch (Exception e) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("El tiempo es: " + timeElapsed.getSeconds());
        }
    }

    @Test
    public void navigateToGoogleExplicitWait(){
        
        Instant start = Instant.now();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("xpath")));
        } catch (Exception e) {
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            System.out.println("El tiempo es: " + timeElapsed.getSeconds());
        }
    }*/

    @Test
    public void selectElementsMercadoLibre(){
        PageMercadoLibre pageMercadoLibre = new PageMercadoLibre(driver);
        PageProducto pageProducto = new PageProducto(driver);

        pageMercadoLibre.enterCriteriaSearch("balones futbol");

        String expectedName = pageMercadoLibre.nameElementList();
        String expectedPrice = pageMercadoLibre.priceElementList();
        pageMercadoLibre.seletcElementListSearch();
        String obtainName = pageProducto.nameProduct();
        String obtainPrice = pageProducto.priceProduct();

        Assertions.assertAll(
            ()-> Assert.assertEquals(expectedName, obtainName),
            ()-> Assert.assertEquals(expectedPrice, obtainPrice)
        );   
        
    }
}
