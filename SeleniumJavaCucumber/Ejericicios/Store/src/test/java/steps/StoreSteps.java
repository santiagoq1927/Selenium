package steps;


import org.junit.Assert;

import io.cucumber.java.en.*;
import page.PageCar;
import page.PageCategories;
import page.PagePrincipalStore;

public class StoreSteps {
    
    PagePrincipalStore principalPage = new PagePrincipalStore();
    PageCategories categoriesPage = new PageCategories();
    PageCar carPage = new PageCar();

    @Given("^I go to navigate to www.mercadolibre.com$")
    public void iNavigateToStore(){
        principalPage.navigateToStore();
    }

    @When("^select the categories opcion on nav bar$")
    public void selectCategories(){
        principalPage.selectOpcionsNavBar();
    }

    @And("^select the car option$")
    public void selectOptionCar(){
        categoriesPage.selectCarOption();
    }

    @Then("^validate de number brands enable$")
    public void validateBrands(){
        carPage.listBrandsDown();
        int brandsTotal = carPage.numberBrands();
        Assert.assertEquals(79,brandsTotal);
    }

    @And("^I enter a car brand (.+)$")
    public void selectBrandCar(String brand){
        carPage.listBrandsDown();
        carPage.enterBrand(brand);
        carPage.selectResultBrand();
        carPage.searchCars();
    }

    @Then("^validate de number car (.+)$")
    public void validateNumerCarForBrands(String numberCars){
        Assert.assertEquals(numberCars+ " resultados", carPage.textNumerCarsResult());
    }
}
