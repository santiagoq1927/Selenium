package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class DetailProductPage extends BasePage {
    private final By btnBackProduct = By.id("back-to-products");
    private final By lblImageProduct = By.className("inventory_details_img");
    private final By lblPriceProduct = By.className("inventory_details_price");
    private final By lblNameProduct = By.xpath("//div[@data-test='inventory-item-name']");
    private final By lblDescriptionProduct = By.xpath("//div[@data-test='inventory-item-desc']");
    private final By btnAddCartProduct = By.id("add-to-cart");

    @Override
    public void waitPageToLoad() {
        waitPage(lblImageProduct);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(btnBackProduct).isDisplayed()),
                () -> Assertions.assertTrue(find(lblImageProduct).isDisplayed()),
                () -> Assertions.assertTrue(find(lblPriceProduct).isDisplayed()),
                () -> Assertions.assertTrue(find(lblNameProduct).isDisplayed()),
                () -> Assertions.assertTrue(find(lblDescriptionProduct).isDisplayed()),
                () -> Assertions.assertTrue(find(btnAddCartProduct).isDisplayed())
        );
    }
}
