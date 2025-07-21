package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaginaList;

public class ListaSteps {

    PaginaList landingList = new PaginaList();
    
    @Given("^I navigate to the list page$")
    public void iNavigateToListPage(){
        landingList.navigateToPaginaList();
    }

    @When("^I search the list$")
    public void searchList() throws InterruptedException{
        landingList.enterSearchCriteria();
    }

    @Then("^I can find the text in the list$")
    public void textInList(){
        List<String> lista = landingList.getAllSearchResult();
        boolean textIsThere = lista.contains("Seattle, Washington");
        if(textIsThere){
            System.out.println("Pased");
        }else{
            throw new Error("Falied");
        }
        
    }
    
}
