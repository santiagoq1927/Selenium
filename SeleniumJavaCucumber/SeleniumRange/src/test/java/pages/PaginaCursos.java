package pages;

public class PaginaCursos extends BasePage{

    private String instroduccionTestingLink = "//a[@href='/introduccion-al-testing-de-software'][normalize-space()='Ver producto']";
    private String fundamentoosTestingLink = "//h3[normalize-space()='Fundamentos del Testing']";
    
    public PaginaCursos(){
        super(driver);
    }

    public void clickFundamentosTesting(){
        clickElement(fundamentoosTestingLink);
    }

    public void clickIntruduccionTesting(){
        clickElement(instroduccionTestingLink);
    }
}
