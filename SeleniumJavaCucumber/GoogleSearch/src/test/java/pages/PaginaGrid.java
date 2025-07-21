package pages;

public class PaginaGrid extends BasePage{

    private String cell="//*[@id='root']/div/";
    
    public PaginaGrid(){
        super(driver);
    }

    public void navigateToGrid(){
        navigateTo("https://1v2njkypo4.csb.app");
    }

    public String getValueFromGrid(int row, int col){
        return getValueFromTable(cell,row,col);
    }
}
