package com.testautomation.SeleniumFramework;


import io.cucumber.java.Before;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
public class CucumberConfiguration {

    @Before
    public void setup(){
        System.out.println("Context started");
    }
}
