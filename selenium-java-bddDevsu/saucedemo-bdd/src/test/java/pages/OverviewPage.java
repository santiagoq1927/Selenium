package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class OverviewPage extends BasePage {
    private final By lblTitleOverview = By.className("title");
    private final By btnFinish = By.id("finish");
    @Override
    public void waitPageToLoad() {
        waitPage(lblTitleOverview);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblTitleOverview).isDisplayed()),
                () -> Assertions.assertTrue(find(btnFinish).isDisplayed())
        );
    }

    public void selectFinish(){
        find(btnFinish).click();
    }
}
