package pages;

public class PaginaPrincipal extends BasePage{

    private String  sectionLink = "//a[normalize-space()='%s' and @href]";
    private String  cursosLink = "//a[normalize-space()='Cursos' and @href]";
    private String  eleginPlanBoton = "//a[normalize-space()='Elegir Plan' and @href]";

    public PaginaPrincipal(){
        super(driver);
    }

    //Metodo para navegar a www.freerangetesters.com
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }

    public void clickOnSectionNavigationBar(String section){
        //Reemplaza el marcador de posicion con el nombre
        String xPathSection = String.format(sectionLink,section);
        clickElement(xPathSection);
    }

    public void clickOnCursosnNavigationBar(){
        clickElement(cursosLink);
    }

    public void clickElegirPlanBoton(){
        clickElement(eleginPlanBoton);
    }
    
}
