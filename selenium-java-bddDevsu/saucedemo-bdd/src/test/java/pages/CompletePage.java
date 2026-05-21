package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class CompletePage extends BasePage {
    private final By lblTitleComplete = By.className("title");
    private final By lblCompletePurchase = By.xpath("//h2[@data-test='complete-header']");

    @Override
    public void waitPageToLoad() {
        waitPage(lblTitleComplete);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblTitleComplete).isDisplayed()),
                () -> Assertions.assertTrue(find(lblCompletePurchase).isDisplayed())
        );
    }

    public void validateMessageComplete(String message){
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblCompletePurchase).isDisplayed()),
                () -> Assertions.assertEquals(find(lblCompletePurchase).getText(),message)
        );
    }
}
