package utilities;

import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    public final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver(){
        if(runServer){
            buildRemoteDriver();
        }else {
            buildLocalDriver();
        }
    }

    public void quitDriver(){

        new WebDriverProvider().get().quit();
    }

    public void buildLocalDriver(){
        final var driver = new ChromeDriver();
        driver.manage().window().maximize();
        new WebDriverProvider().set(driver);
    }

    public void buildRemoteDriver(){

    }
}
