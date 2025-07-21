package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import constantsglobal.ConstantsGeneral;

public class SauceLoginPage extends Base{

    @FindBy(xpath = ConstantsGeneral.INPUT_USERNAME)
    private WebElement inpUserName;

    @FindBy(xpath = ConstantsGeneral.INPUT_PASSWORD)
    private WebElement inpPassword;

    @FindBy(xpath = ConstantsGeneral.BUTTON_LOGIN)
    private WebElement btnLogin;

    private By userNameInput = By.xpath(ConstantsGeneral.INPUT_USERNAME);
    private By passwordInput = By.xpath(ConstantsGeneral.INPUT_PASSWORD);
    private By loginButton = By.xpath(ConstantsGeneral.BUTTON_LOGIN);
    private By carIcon = By.xpath(ConstantsGeneral.ICON_CART);

    public SauceLoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUserName(String username){
        clearInput(userNameInput);
        insertValue(userNameInput, username);
    }

    public void enterPassword(String password){
        clearInput(passwordInput);
        insertValue(passwordInput, password);
    }

    public void selectLogin(){
        clickButton(loginButton);
    }

    public boolean validateIconCar(){
        return isDisplayed(carIcon);
    }

    public void Login(String username, String password){
        this.enterUserName(username);
        this.enterPassword(password);
        this.selectLogin();
    }

}
