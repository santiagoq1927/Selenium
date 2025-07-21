package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import constantsglobal.ConstantsGeneral;

public class MenuOptionsPage extends Base{

    private By menuOptions = By.xpath(ConstantsGeneral.BUTTON_OPTIONS);
    private By aboutOption = By.xpath(ConstantsGeneral.OPTION_ABOUT_MENU);
    private By imgAboutValidation = By.xpath(ConstantsGeneral.IMG_VALIDATE_ABOUT);

    public MenuOptionsPage(WebDriver driver){
        super(driver);
    }

    public void selectMenu() throws InterruptedException{
        waitVisibleElement(menuOptions, 2);
        clickButton(menuOptions);
    }

    public void selectAboutOption(){
        waitVisibleElement(aboutOption, 2);
        clickButton(aboutOption);
    }

    public boolean validateAboutPage(){
        return isExistElement(imgAboutValidation);
    }

    public void selectAbout() throws InterruptedException{
        this.selectMenu();
        this.selectAboutOption();
    }
}
