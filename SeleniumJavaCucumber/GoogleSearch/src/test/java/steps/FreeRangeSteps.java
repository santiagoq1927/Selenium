package steps;


import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;
import pages.PaginaResultado;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaResultado resultPage = new PaginaResultado();

    @Given("^I navegate in www.google.com$")
    public void iNavigateToGoogle(){
        landingPage.navigateToGoogle();
    }

    @When("^I enter a text in search bar$")
    public void enterTextSearch(){
        landingPage.enterTextSearch();
    }
    
    @When("^and select is search$")
    public void selectButtonSearch(){
        landingPage.selectSearchButton();
    }

    @Then("^the text status is visible$")
    public void validateTextStatus(){
        Assert.assertTrue("Exploto",resultPage.textStatus());
    }

    @Then("^the results  match the criteria$")
    public void validateResults(){
        Assert.assertEquals("Colombia",resultPage.resultSearch());
    }
    
}
