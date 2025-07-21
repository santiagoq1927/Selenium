package pages;

public class PaginaPrincipal extends BasePage{

    private String inputSearch = "//input[@id='cb1-edit']";
    private String buttonSearch = "//div[@aria-label='Buscar']";
    private String selectElement = "//li[@class='ui-search-layout__item shops__layout-item']";
    private String buttonCar = "//button[@class='andes-button andes-spinner__icon-base ui-pdp-action--secondary andes-button--quiet']";

    public PaginaPrincipal(){
        super(driver);
    }

    public void navigateToAmazon(){
        navigateTo("https://www.mercadolibre.com.co/");
    }

    public void enterCriteriaSearch(){
        write(inputSearch,"Alexa");
    }

    public void searchCriteria(){
        clickElement(buttonSearch);
    }

    public void selectSecondPage(){
        goToLinkText("2");
    }

    public void selectThridElement(){
        selectNthElement(selectElement,3);
    }

    public boolean buttonEnable(){
        return elementDisplay(buttonCar);
    }

    public void selectAddCar(){
        clickElement(buttonCar);
    }

    
}
