package com.testautomation.SeleniumFramework.pageobjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
public class SignupPage{


    private WebDriver driver;

    public SignupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement inpFistName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement inpLastName;

    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    private WebElement inpEmailAddress;

    @FindBy(xpath = "//input[@ng-model='Phone']")
    private WebElement inpPhone;

    @FindBy(xpath = "//input[@name='radiooptions' and @value='Male']")
    private WebElement rbtGanderMale;

    @FindBy(xpath = "//select[@id='countries']")
    private WebElement cbxCountry;

    @FindBy(xpath = "//select[@id='yearbox']")
    private WebElement cbxYear;

    @FindBy(xpath = "//select[@ng-model='monthbox']")
    private WebElement cbxMonth;

    @FindBy(xpath = "//select[@id='daybox']")
    private WebElement cbxDay;

    @FindBy(xpath = "//input[@ng-model='Password']")
    private WebElement inpPassword;

    @FindBy(xpath = "//input[@ng-model='CPassword']")
    private WebElement inpConfirmPassword;

    @FindBy(xpath = "//button[@id='submitbtn']")
    private WebElement btnSubmit;

}
