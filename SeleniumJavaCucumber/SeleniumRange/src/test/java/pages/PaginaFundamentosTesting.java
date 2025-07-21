package pages;

public class PaginaFundamentosTesting extends BasePage{

    private String introduccionTestingLink = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Introducción al Testing de Software']";
    private String istqbLink = "//h4[normalize-space()='ISTQB Foundation Level Versión 4 - Español']";

    public PaginaFundamentosTesting(){
        super(driver);
    }

    public void clickIntruduccionTesting(){
        clickElement(introduccionTestingLink);
    }

    public void clickIstqb(){
        clickElement(istqbLink);
    }
    
}
