package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class CartPage extends BasePage {
    private final By lblTitleCart = By.className("title");
    private final By btnCheckout = By.id("checkout");

    @Override
    public void waitPageToLoad() {
        waitPage(lblTitleCart);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblTitleCart).isDisplayed()),
                () -> Assertions.assertTrue(find(btnCheckout).isDisplayed())
        );
    }

    public void selectCheckout(){
        find(btnCheckout).click();
    }


}
