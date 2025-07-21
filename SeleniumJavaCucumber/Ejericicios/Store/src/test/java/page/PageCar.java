package page;

public class PageCar extends BasePage {

    private String listBrands = "//li[@role='option']//span[@class='andes-list__item-primary']";
    private String listDown = "//button[@id=':r1:-trigger']//div[@class='andes-dropdown__chevron']//*[name()='svg']";
    private String searchBrand = "//input[@placeholder='Buscar']";
    private String buttonSearch = "//button[@id=':r4:']";
    private String resultBrand = "//div[@class='andes-list__item-first-column']";
    private String numberResultSearch = "//span[@class='ui-search-search-result__quantity-results']";

    public PageCar(){
        super(driver);
    }

    public void listBrandsDown(){
        scrollToElement(listDown);
        clickElement(listDown);
    }

    public int numberBrands(){
        int numberElements=listSizeElement(listBrands);
        return numberElements;
    }

    public void enterBrand(String brand){
        write(searchBrand, brand);
    }

    public void searchCars(){
        clickElement(buttonSearch);
    }

    public void selectResultBrand(){
        clickElement(resultBrand);
    }

    public String textNumerCarsResult(){
        return textElement(numberResultSearch);
    }
}
