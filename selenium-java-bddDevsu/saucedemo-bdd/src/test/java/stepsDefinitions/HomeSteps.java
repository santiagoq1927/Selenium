package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import utilities.CommonFlows;

public class HomeSteps {
    private final CommonFlows commonFlows = new CommonFlows();
    private final HomePage homePage = new HomePage();

    @Given("a user logs in the home page")
    public void goHomePage() {
        commonFlows.goHomePage();
    }

    @Then("the user verify the elements in the home page")
    public void verifyHomePage() {
        homePage.verifyPage();
    }
}
