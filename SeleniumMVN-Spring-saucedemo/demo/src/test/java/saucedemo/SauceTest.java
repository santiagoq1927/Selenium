package saucedemo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import constantsglobal.ConstantsGeneral;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.CartPage;
import pageobject.CheckoutCompletePage;
import pageobject.CheckoutOverviewPage;
import pageobject.CheckoutPage;
import pageobject.MenuOptionsPage;
import pageobject.SauceInitialPage;
import pageobject.SauceLoginPage;


public class SauceTest{
    
    private WebDriver driver;

    @Autowired
    private SauceLoginPage sauceLoginPage;

    @Autowired
    private MenuOptionsPage menuOptionsPage;

    @Autowired
    private SauceInitialPage sauceInitialPage;

    @Autowired
    private CartPage cartPage;

    @Autowired
    private CheckoutPage checkoutPage;

    @Autowired
    private CheckoutOverviewPage checkoutOverview;

    @Autowired
    private CheckoutCompletePage checkoutComplete;
    
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sauceLoginPage = PageFactory.initElements(driver,SauceLoginPage.class);
        menuOptionsPage = PageFactory.initElements(driver,MenuOptionsPage.class);
        sauceInitialPage = PageFactory.initElements(driver,SauceInitialPage.class);
        cartPage = PageFactory.initElements(driver,CartPage.class);
        checkoutPage = PageFactory.initElements(driver,CheckoutPage.class);
        checkoutOverview = PageFactory.initElements(driver,CheckoutOverviewPage.class);
        checkoutComplete = PageFactory.initElements(driver,CheckoutCompletePage.class);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginSuaceDemo() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);
        assertTrue(sauceLoginPage.validateIconCar());
    }

    @Test
    public void aboutOptions() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);
        assertTrue(sauceLoginPage.validateIconCar());
        menuOptionsPage.selectAbout();
        //assertTrue(menuOptionsPage.validateAboutPage());
    }

    @Test
    public void selectFilterOptions() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);
        assertTrue(sauceLoginPage.validateIconCar());

        String textProduct = sauceInitialPage.textProductTitle();
        assertEquals(textProduct,ConstantsGeneral.TEXT_VALIDATION_PRODUCT);

        sauceInitialPage.selectFilterValue("lohi");
        String textFilterSelect = sauceInitialPage.textOpcionSelect();
        System.out.println("Text filter is: " + textFilterSelect);
        assertEquals(textFilterSelect,ConstantsGeneral.TEXT_SELECT_OPTION);
        Thread.sleep(2000);

    }

    @Test
    public void selectProducts() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);
        assertTrue(sauceLoginPage.validateIconCar());

        String textProduct = sauceInitialPage.textProductTitle();
        assertEquals(textProduct,ConstantsGeneral.TEXT_VALIDATION_PRODUCT);

        sauceInitialPage.selectAddProductCart();
        sauceInitialPage.selectCart();
        String titleActual = "Your Cart";
        String titleValidationCart = cartPage.titleValidation();
        assertEquals(titleValidationCart,titleActual);
        Thread.sleep(2000);

    }

    @Test
    public void selectCheckout() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);

        sauceInitialPage.selectAddProductCart();
        sauceInitialPage.selectCart();
        String titleValidationCartExpected = cartPage.titleValidation();
        assertEquals(titleValidationCartExpected,ConstantsGeneral.TEXT_TITLE_CART_ACTUAL);

        cartPage.selectCheckout();
        String titleCheckoutExpected = checkoutPage.titleValidation();
        assertEquals(titleCheckoutExpected,ConstantsGeneral.TEXT_TITLE_CHECKOUT_ACTUAL);

        Thread.sleep(2000);
    }

    @Test
    public void selecContinueToOverview() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);

        sauceInitialPage.selectAddProductCart();
        sauceInitialPage.selectCart();

        cartPage.selectCheckout();
        String titleCheckoutExpected = checkoutPage.titleValidation();
        assertEquals(titleCheckoutExpected,ConstantsGeneral.TEXT_TITLE_CHECKOUT_ACTUAL);

        checkoutPage.enterInformation("Nombre", "Apellido", "190002");
        String titlrCheckoutOverviewExcpected = checkoutOverview.titleCheckoutOverview();
        assertEquals(titlrCheckoutOverviewExcpected,ConstantsGeneral.TEXT_TITLE_CHECKOUT_OVERVIEW_ACTUAL);

        Thread.sleep(2000);
    }

    @Test
    public void selecFinish() throws InterruptedException{
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        sauceLoginPage.Login(ConstantsGeneral.USERNAME,ConstantsGeneral.PASSWORD);

        sauceInitialPage.selectAddProductCart();
        sauceInitialPage.selectCart();

        cartPage.selectCheckout();

        checkoutPage.enterInformation("Nombre", "Apellido", "190002");
        String titlrCheckoutOverviewExcpected = checkoutOverview.titleCheckoutOverview();
        assertEquals(titlrCheckoutOverviewExcpected,ConstantsGeneral.TEXT_TITLE_CHECKOUT_OVERVIEW_ACTUAL);
        checkoutOverview.selectFinish();

        String titleCheckOverviewCompleteExpected = checkoutComplete.titleCheckoutComplete();
        assertEquals(titleCheckOverviewCompleteExpected,ConstantsGeneral.TEXT_TITLE_CHECKOUT_COMPLETE_ACTUAL);
        checkoutComplete.selectBackHome();

        String textProduct = sauceInitialPage.textProductTitle();
        assertEquals(textProduct,ConstantsGeneral.TEXT_VALIDATION_PRODUCT);

        Thread.sleep(2000);
    }

}
