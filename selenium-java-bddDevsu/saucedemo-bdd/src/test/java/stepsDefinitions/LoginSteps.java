package stepsDefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;
import utilities.CommonFlows;

public class LoginSteps {
    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();

    @Given("a user navigate to login page")
    public void goLoginPage() {
        commonFlows.goLoginPage();
    }

    @When("the user enter username {string} with the password {string} and select login button")
    public void login(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("show the home page")
    public void showHomePage() {
        homePage.verifyProductLabel("Products");
    }

    @When("the user enter locked username {string} with the password {string} and select login button")
    public void credentialsInvalid(String username, String password) {
        loginPage.login(username,password);
    }

    @Then("show a error message {string}")
    public void validateErrorMessage(String messageError) {
        loginPage.verifyMessageError(messageError);
    }
}
