package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.buycart.BuyCartPage;
import pages.checkout.CheckoutComplete;
import pages.checkout.CheckoutInformationPage;
import pages.checkout.CheckoutOverviewPage;
import pages.logil.LoginPage;
import pages.principalpage.PrincipalPage;
import pages.productpage.ProductPage;
import com.github.javafaker.Faker;

public class SaucedemoSteps {

    LoginPage loginPage = new LoginPage();
    PrincipalPage principalPage = new PrincipalPage();
    ProductPage productPage = new ProductPage();
    BuyCartPage buyCartPage = new BuyCartPage();
    CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage();
    Faker faker = new Faker();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutComplete checkoutComplete = new CheckoutComplete();

    private String postalcode= "190002";
    private String namePageInital = "Swag Labs";

    @Given("I navigate in soucedemo page")
    public void navigateToSaucedemo(){
        loginPage.navigateToSaucedemo();
    }

    @When("enter username, password and continue")
    public void login(){
        loginPage.enterLogin("standard_user", "secret_sauce");
    }

    @Then("I am redirect to main page")
    public void validatePrincipalPage(){
        namePageInital = principalPage.textNamePage();
        Assert.assertEquals(namePageInital, "Swag Labs");
    }

    @When("select Sauce Labs Backpack element and add buy cart")
    public void addBuytoCart(){
        principalPage.selectFirstElement();
        productPage.selectAddCart();
    }

    @When("go to cart and make checkout")
    public void checkout(){
        principalPage.selectBuyCart();
        buyCartPage.selectCheckout();
    }

    @When("enter information for send and finish buy")
    public void finishbuy(){
        checkoutInformationPage.enterInformation(faker.name().firstName(),faker.name().lastName(), postalcode);
        checkoutOverviewPage.selectFinish();
    }
    
    @Then("informs the user order succesful")
    public void validateBuyFinish(){
        String textFinish = checkoutComplete.textFinish();
        String txtComplete = checkoutComplete.textComplete();
        String txtNamePage = principalPage.textNamePage();
        Assert.assertEquals(textFinish, "Thank you for your order!");
        Assert.assertEquals(txtComplete, "Checkout: Complete!");
        Assert.assertEquals(namePageInital, txtNamePage);
    }
}
