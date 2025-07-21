package steps;

import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.*;
import pages.PaginaCursos;
import pages.PaginaFundamentosTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistroPlan;

public class FreeRangeSteps {

    SoftAssert sotf = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos landingCursos = new PaginaCursos();
    PaginaFundamentosTesting landingFundamentos = new PaginaFundamentosTesting();
    PaginaRegistroPlan landinRegistroPlan = new PaginaRegistroPlan();

    @Given("I navegate in www.freerunnertesters.com")
    public void iNavigateToFRT(){
        landingPage.navigateToFreeRangeTesters();
    }
    
    @When("I go to a {word} using the navigation bar")
    public void navigationBarUse(String section){
        landingPage.clickOnSectionNavigationBar(section);
    }
    @When("I select the botton for choose a plan in the page")
    public void navigationElegirPlanBoton(){
        landingPage.clickElegirPlanBoton();
    }
    @And("select instruduccion al testing")
    public void navigationFundamentosTesting(){
        landingCursos.clickIntruduccionTesting();
    }
    @Then("^(?:I|The user) can validate the option in the checkout page$")
    public void validateOptionsPlan(){
        List<String> listaPlanes = landinRegistroPlan.returnPlanDropDown();
        
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 13 productos",
            "Academia: $176 / año • 13 productos","Free: Gratis • 3 productos");   
        Assert.assertNotEquals(listaEsperada,listaPlanes);
    }

    public void EjemplosAssert(){
        String palabraEsperada = "Pepe";
        String palabraEncontrada = "Papa";

        //Vertificar que los valores son iguales
        Assert.assertEquals(palabraEncontrada, palabraEsperada);

        //Vertificar que los valores no son iguales
        Assert.assertNotEquals(palabraEncontrada, palabraEsperada);

        //Verificar que una condicion sea verdadera 
        //contains verifica que una parte del texto este, no es necesario que este todo completo, solo una parte
        Assert.assertTrue(palabraEncontrada.contains(palabraEsperada));

        //Verificar que una condicion sea falsa 
        Assert.assertFalse(palabraEncontrada.contains(palabraEsperada));

        //Soft Assertions: no detienen la ejecucion al fallar, ideal para verificar muchas cosas pequeñas a la ves.
        sotf.assertEquals(palabraEncontrada,palabraEsperada);
        sotf.assertTrue(palabraEncontrada.contains(palabraEsperada));
        sotf.assertNotEquals(palabraEncontrada,palabraEsperada);
        sotf.assertAll();


    }
}
