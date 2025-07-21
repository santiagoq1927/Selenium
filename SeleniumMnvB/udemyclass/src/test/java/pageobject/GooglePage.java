package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {

    @FindBy(xpath = "//textarea[@title='Buscar']")
    private WebElement inpSearch;

    public WebElement getInputSearch(){
        return inpSearch;
    }


    public void enterSearchText(String textSearch){

        inpSearch.clear();
        inpSearch.sendKeys(textSearch);
        inpSearch.submit();
    }


}
