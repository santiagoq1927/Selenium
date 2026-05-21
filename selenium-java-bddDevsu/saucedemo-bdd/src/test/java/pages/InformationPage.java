package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import utilities.BasePage;

public class InformationPage extends BasePage {
    private final By lblTitleInformation = By.className("title");
    private final By inpFirstname = By.id("first-name");
    private final By inpLastname = By.id("last-name");
    private final By inpZipcode = By.id("postal-code");
    private final By btnContinue = By.id("continue");

    @Override
    public void waitPageToLoad() {
        waitPage(lblTitleInformation);
    }

    @Override
    public void verifyPage() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(find(lblTitleInformation).isDisplayed()),
                () -> Assertions.assertTrue(find(inpFirstname).isDisplayed()),
                () -> Assertions.assertTrue(find(inpLastname).isDisplayed()),
                () -> Assertions.assertTrue(find(inpZipcode).isDisplayed()),
                () -> Assertions.assertTrue(find(btnContinue).isDisplayed())
        );
    }

    public void enterFirstName(String firstname){
        find(inpFirstname).sendKeys(firstname);
    }

    public void enterLastName(String lastname){
        find(inpLastname).sendKeys(lastname);
    }

    public void enterZipcode(String zipcode){
        find(inpZipcode).sendKeys(zipcode);
    }

    public void enterInformation(String firstname, String lastname, String zipcode){
        enterFirstName(firstname);
        enterLastName(lastname);
        enterZipcode(zipcode);
        find(btnContinue).click();
    }
}
