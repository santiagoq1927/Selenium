package com.testautomation.SeleniumFramework.pageobjects;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;


public class SignupServicePage {


    private WebDriver driver;

    private  SignupPage signupPage;

    public SignupServicePage(WebDriver driver){
        this.driver=driver;
        signupPage = new SignupPage(driver);
    }

    public  void go(String url){
        this.driver.get(url);
    }

    public void enterName(String name){
        this.signupPage.getInpFistName().sendKeys(name);
    }

    public void enterLastName(String lastName){
        signupPage.getInpLastName().sendKeys(lastName);
    }

    public void enterEmailAddress(String emailAddress){
        signupPage.getInpEmailAddress().sendKeys(emailAddress);
    }

    public void enterPhone(String phone){
        signupPage.getInpPhone().sendKeys(phone);
    }

    public void selectGander(){
        signupPage.getRbtGanderMale().click();
    }

    public void selectCountry(String country){
        Select selectCountry = new Select(signupPage.getCbxCountry());
        selectCountry.selectByVisibleText(country);
    }

    public void selectYear(String year){
        Select selectYear = new Select(signupPage.getCbxYear());
        selectYear.selectByVisibleText(year);
    }

    public void selectMonth(String month){
        Select selectMonth = new Select(signupPage.getCbxMonth());
        selectMonth.selectByVisibleText(month);
    }

    public void selectDay(String day){
        Select selectDay = new Select(signupPage.getCbxDay());
        selectDay.selectByVisibleText(day);
    }

    public void enterPassword(String password){
        signupPage.getInpPassword().sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        signupPage.getInpConfirmPassword().sendKeys(confirmPassword);
    }

    public void submit(){
        signupPage.getBtnSubmit().click();
    }

}
