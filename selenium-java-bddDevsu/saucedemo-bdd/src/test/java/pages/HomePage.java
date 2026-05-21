package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class HomePage extends BasePage {
    private final By lblProduct = By.xpath("//span[@data-test='title']");
    private final By inventoryList = By.className("inventory_list");
    private final By btnListAdd = By.xpath("//button[text()='Add to cart']");

    @Override
    public void waitPageToLoad() {
        waitPage(inventoryList);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblProduct).isDisplayed()),
                () -> Assertions.assertTrue(find(inventoryList).isDisplayed())
        );
    }

    public void verifyProductLabel(String labelProduct){
        final var productElement = find(lblProduct);
        Assertions.assertAll(
                () -> Assertions.assertTrue(productElement.isDisplayed()),
                () -> Assertions.assertEquals(productElement.getText(),labelProduct)
        );
    }

    private By productItemName(String name){
        final var xpathItem = String.format("//div[text()='%s']",name);
        return By.xpath(xpathItem);
    }

    public void selectProduct(String name){
        find(productItemName(name)).click();
    }

    public void selectProductIndex(int index){
        findAll(btnListAdd).get(index).click();
    }
}
