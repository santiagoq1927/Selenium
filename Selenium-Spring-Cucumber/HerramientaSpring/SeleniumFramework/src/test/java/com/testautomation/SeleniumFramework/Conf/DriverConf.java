package com.testautomation.SeleniumFramework.Conf;

import io.cucumber.spring.ScenarioScope;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class DriverConf {

    @Bean(destroyMethod = "quit")
    @ScenarioScope
    public WebDriver webDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
