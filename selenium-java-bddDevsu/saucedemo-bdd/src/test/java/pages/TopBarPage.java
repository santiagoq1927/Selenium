package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class TopBarPage extends BasePage {
    private final By lblTitle = By.className("app_logo");
    private final By btnCart = By.className("shopping_cart_link");

    @Override
    public void waitPageToLoad() {
        waitPage(lblTitle);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblTitle).isDisplayed()),
                () -> Assertions.assertTrue(find(btnCart).isDisplayed())
        );
    }

    public void selectCart(){
        find(btnCart).click();
    }
}
