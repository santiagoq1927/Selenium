package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import pages.*;
import utilities.CommonFlows;

public class FlowE2ESteps {
    private final CommonFlows commonFlows = new CommonFlows();
    private final HomePage homePage = new HomePage();
    private final TopBarPage topBarPage = new TopBarPage();
    private final CartPage cartPage = new CartPage();
    private final InformationPage informationPage = new InformationPage();
    private final User user = new User();
    private final OverviewPage overviewPage = new OverviewPage();
    private final CompletePage completePage = new CompletePage();

    @Given("a user logs in the home page for sauce demo")
    public void aUserLogsInTheHomePageForSauceDemo() {
        commonFlows.goHomePage();
    }

    @When("the user add two products")
    public void theUserAddTwoProducts() {
        homePage.selectProductIndex(0);
        homePage.selectProductIndex(1);
    }

    @And("select the cart by click on checkout")
    public void selectTheCartByClickOnCheckout() {
        topBarPage.selectCart();
        cartPage.waitPageToLoad();
        cartPage.selectCheckout();
    }

    @And("complete information and continue")
    public void completeInformationAndContinue() {
        informationPage.waitPageToLoad();
        informationPage.enterInformation(user.getFirstname(),user.getLastname(),user.getZipcode());
    }

    @Then("finish with de purchase")
    public void finishWithDePurchase() {
        overviewPage.waitPageToLoad();
        overviewPage.selectFinish();
    }

    @And("the system display a message {string}")
    public void theSystemDisplayAMessage(String message) {
        completePage.validateMessageComplete(message);
    }
}
