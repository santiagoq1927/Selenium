package pages;

public class PaginaPrincipal extends BasePage{

    private String barSearch = "//textarea[@aria-label='Buscar']"; 
    private String searchButton = "//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']";   

    public PaginaPrincipal(){
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void enterTextSearch(){
        write(barSearch, "Colombia");
    }

    public void selectSearchButton(){
        clickElement(searchButton);
    }
    
}
