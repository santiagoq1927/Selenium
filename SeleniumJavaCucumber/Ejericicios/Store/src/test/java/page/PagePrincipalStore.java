package page;
public class PagePrincipalStore extends BasePage {

    private String navBarOptions = "//li[@class='nav-menu-item']";

    public PagePrincipalStore(){
        super(driver);
    }
    
    public void navigateToStore(){
        navigateTo("https://www.mercadolibre.com.co/");
    }

    public void selectOpcionsNavBar(){
        selectNthElement(navBarOptions,0);
    }

}
