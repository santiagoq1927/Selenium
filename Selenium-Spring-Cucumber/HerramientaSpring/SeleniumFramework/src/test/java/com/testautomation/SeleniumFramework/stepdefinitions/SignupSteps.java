package com.testautomation.SeleniumFramework.stepdefinitions;

import com.testautomation.SeleniumFramework.pageobjects.SignupServicePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

@ScenarioScope
public class SignupSteps {

    @Autowired
    private WebDriver driver;


    @Given("a client wants to have an account")
    public void a_client_wants_to_have_an_account() {
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @When("he send required information to get the account")
    public void he_send_required_information_to_get_the_account() throws InterruptedException {

        SignupServicePage signupServicePage = new SignupServicePage(this.driver);
        signupServicePage.enterName("Gustavo");
        signupServicePage.enterLastName("Ramos");
        signupServicePage.enterEmailAddress("ramos@gmail.com");
        signupServicePage.enterPhone("3225554432");
        signupServicePage.selectGander();
        //signupServicePage.selectCountry("Colombia");
        signupServicePage.selectYear("1995");
        signupServicePage.selectMonth("August");
        signupServicePage.selectDay("27");
        signupServicePage.enterPassword("cucumber2024");
        signupServicePage.enterConfirmPassword("cucumber2024");

        signupServicePage.submit();
        Thread.sleep(6000);
    }
    @Then("he should be told that the account was no created")
    public void he_should_be_told_that_the_account_was_no_created() {

        //assertThat(true).isEqualTo(false);
    }
}
