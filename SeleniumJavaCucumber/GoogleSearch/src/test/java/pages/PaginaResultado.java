package pages;

public class PaginaResultado extends BasePage {

    private String resultaObtenido = "//div[@role='heading'][normalize-space()='Colombia']";

    public PaginaResultado(){
        super(driver);
    }

    public String resultSearch(){
        return textFromElement(resultaObtenido);
    }
    
    public boolean textStatus(){
        return elementDisplay(resultaObtenido);
    }
}
