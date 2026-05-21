package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class LoginPage extends BasePage {

    private final By inpUsername = By.id("user-name");
    private final By inpPassword = By.id("password");
    private final By btnLogin = By.id("login-button");
    private final By lblError = By.xpath("//h3[@data-test='error']");

    @Override
    public void waitPageToLoad() {
        waitPage(inpUsername);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(inpUsername).isDisplayed()),
                () -> Assertions.assertTrue(find(inpPassword).isDisplayed()),
                () -> Assertions.assertTrue(find(btnLogin).isDisplayed())
        );
    }

    public void enterUsername(String username){
        find(inpUsername).sendKeys(username);
    }

    public void enterPassword(String password){
        find(inpPassword).sendKeys(password);
    }

    public void login(String username, String password){
        this.enterUsername(username);
        this.enterPassword(password);
        find(btnLogin).click();
    }

    public void verifyMessageError(String messageError){
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblError).isDisplayed()),
                () -> Assertions.assertEquals(find(lblError).getText(),messageError)
        );
    }
}
