package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class PaginaList extends BasePage{

    private String searchField = "";
    private String searchResult = "";

    public PaginaList(){
        super(driver);
    }
    
    public void navigateToPaginaList(){
        navigateTo("");
    }

    public void enterSearchCriteria() throws InterruptedException{
        Thread.sleep(600);
        write(searchField,"Washington");
    }

    public List<String> getAllSearchResult(){
        List<WebElement> list = bringMeAllElements(searchResult);
        List<String> stringFromList = new ArrayList<String>();
        for(WebElement e:list){
            stringFromList.add(e.getText());
        }
        return stringFromList;
    }
}
