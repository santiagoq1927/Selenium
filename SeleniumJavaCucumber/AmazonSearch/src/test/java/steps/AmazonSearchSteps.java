package steps;


import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.PaginaPrincipal;

public class AmazonSearchSteps {

    PaginaPrincipal paginaAmazon = new PaginaPrincipal();

    @Given("^I access in www.amazon.com$")
    public void iNavigateToAmazon(){
        paginaAmazon.navigateToAmazon();
    }
    @When("^Search for alexa$")
    public void enterSearchAmazon(){
        paginaAmazon.enterCriteriaSearch();
        paginaAmazon.searchCriteria();
    }
    @When("^selects the third item$")
    public void selectItemAmazon(){
        paginaAmazon.selectThridElement();   
    }
    @Then("^the user is able to add it to the cart$")
    public void buttonValidate(){
        
        Assert.assertTrue(paginaAmazon.buttonEnable());   
    }
}
