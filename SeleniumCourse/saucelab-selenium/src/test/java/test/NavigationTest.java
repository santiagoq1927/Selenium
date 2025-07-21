package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import page.BuyCartPage;
import page.CheckoutInformationPage;
import page.CheckoutOverviewPage;
import page.InitialPage;
import page.LoginPage;

public class NavigationTest{

    private WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void FlowCartProducts() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        InitialPage initialPage = new InitialPage(driver);
        BuyCartPage buyCartPage = new BuyCartPage(driver);

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        
        String username="standard_user", password="secret_sauce";
        loginPage.toLogin(username, password);
        

        initialPage.selectAnElement(4);
        String nameproductOneInital = initialPage.textNameProduct(4);
        String priceOneInitial = initialPage.textPriceProduct(4);
        initialPage.selectAnElement(0);
        String nameproductTwoInital = initialPage.textNameProduct(0);
        String priceTwoInital = initialPage.textPriceProduct(0);

        initialPage.selectBuyCart();
        
        String nameproductOneBuyCart = buyCartPage.textNameProductBuyCart(0);
        String priceOneBuyCart = buyCartPage.textPriceProductBuyCart(0);
        String nameproductTwoBuyCart = buyCartPage.textNameProductBuyCart(1);
        String priceTwoBuyCart = buyCartPage.textPriceProductBuyCart(1);

        Assert.assertEquals(nameproductOneInital, nameproductOneBuyCart);
        Assert.assertEquals(nameproductTwoInital, nameproductTwoBuyCart);
        Assert.assertEquals(priceOneInitial, priceOneBuyCart);
        Assert.assertEquals(priceTwoInital, priceTwoBuyCart);

        Thread.sleep(5000);

    }

    @Test
    public void FlowCheckoutOverviewText() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        InitialPage initialPage = new InitialPage(driver);
        BuyCartPage buyCartPage = new BuyCartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Faker faker = new Faker();        

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        
        String username="standard_user", password="secret_sauce", postalCode="190002";
        loginPage.toLogin(username, password);
        
        initialPage.selectAnElement(4);
        initialPage.selectAnElement(0);
        initialPage.selectBuyCart();
        
        String nameproductOneBuyCart = buyCartPage.textNameProductBuyCart(0);
        String priceproductOneBuyCart = buyCartPage.textPriceProductBuyCart(0);
        String nameproductTwoBuyCart = buyCartPage.textNameProductBuyCart(1);
        String priceproductTwoBuyCart = buyCartPage.textPriceProductBuyCart(1);

        buyCartPage.selectCheckout();
        checkoutInformationPage.enterInfo(faker.name().firstName(),faker.name().lastName(), postalCode);
        
        String nameproductOneOverview = checkoutOverviewPage.textNameproductOverview(0);
        String priceproductOneOverview = checkoutOverviewPage.textPriceproductOverview(0);
        String nameproductTwoOverview = checkoutOverviewPage.textNameproductOverview(1);
        String priceproductTwoOverview = checkoutOverviewPage.textPriceproductOverview(1);

        Assert.assertEquals(nameproductOneBuyCart, nameproductOneOverview);
        Assert.assertEquals(nameproductTwoBuyCart, nameproductTwoOverview);
        Assert.assertEquals(priceproductOneBuyCart, priceproductOneOverview);
        Assert.assertEquals(priceproductTwoBuyCart, priceproductTwoOverview);

        Thread.sleep(5000);
    }

    @Test
    public void FlowCheckoutOverviewPrices() throws InterruptedException{
        LoginPage loginPage = new LoginPage(driver);
        InitialPage initialPage = new InitialPage(driver);
        BuyCartPage buyCartPage = new BuyCartPage(driver);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Faker faker = new Faker();        

        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        
        String username="standard_user", password="secret_sauce", postalCode="190002";
        loginPage.toLogin(username, password);
        
        initialPage.selectAnElement(4);
        initialPage.selectAnElement(0);
        initialPage.selectBuyCart();

        buyCartPage.selectCheckout();
        checkoutInformationPage.enterInfo(faker.name().firstName(),faker.name().lastName(), postalCode);
        
        Double priceproductOneOverview = checkoutOverviewPage.numericPriceProduct(0);
        Double priceproductTwoOverview = checkoutOverviewPage.numericPriceProduct(1);
        Double priceItemtotalOverview = checkoutOverviewPage.numericPriceItemTotal();
        Double priceItemtotalCalculator = priceproductOneOverview + priceproductTwoOverview;
        Double priceTax = checkoutOverviewPage.numericPriceTax();
        Double priceTotal = checkoutOverviewPage.numericPriceTotal();
        Double priceTotalCalculator = priceItemtotalCalculator + priceTax;

        Assert.assertEquals(priceItemtotalOverview, priceItemtotalCalculator);
        Assert.assertEquals(priceTotal,priceTotalCalculator, Math.round(priceTotalCalculator));

        Thread.sleep(5000);
    }
    
}
