package page;

public class PageCategories extends BasePage{

    private String categoriesOptions = "//a[@class='categories__title']";
    private String carOption = "//a[contains(text(),'Carros, Motos')]";

    public PageCategories(){
        super(driver);
    }

    public void selectCategorieOptiones(){

        selectNthElement(categoriesOptions, 11);
    }

    public void selectCarOption(){
        scrollToElement(carOption);
        clickElement(carOption);
    }
    
}
