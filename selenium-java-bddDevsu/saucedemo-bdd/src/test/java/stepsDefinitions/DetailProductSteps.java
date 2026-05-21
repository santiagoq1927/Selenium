package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.DetailProductPage;
import utilities.CommonFlows;

public class DetailProductSteps {
    private final CommonFlows commonFlows = new CommonFlows();
    private final DetailProductPage detailProductPage = new DetailProductPage();

    @Given("a user access product detail with name {string}")
    public void accessProductDetail(String nameProduct) {
        commonFlows.goDetailProduct(nameProduct);
    }

    @Then("the user verify the elements in the product detail page")
    public void verifyProductDetail() {
        detailProductPage.verifyPage();
    }
}
