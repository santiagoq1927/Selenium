package excelFile;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelFileTest {
    
    private WebDriver driver;
    private WriteExcelFile writeExcelFile;
    private ReadExcelFile readExcelFile;
    private String inpSearch = "//input[@id='search_query_top']";
    private String btnSearch = "//button[@name='submit_search']";
    private String txtResult = "//span[@class='heading-counter']";

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        writeExcelFile = new WriteExcelFile();
        readExcelFile = new ReadExcelFile();
    } 

    @Test
    public void downloadFile() throws InterruptedException, IOException{      
        
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        
        String fileExcelPath = "C:\\Users\\Equipo\\Downloads\\automationBase\\store.xlsx";
        String searchText = readExcelFile.getCellValue(fileExcelPath, "Hoja1", 0, 0);
        driver.findElement(By.xpath(inpSearch)).clear();
        driver.findElement(By.xpath(inpSearch)).sendKeys(searchText);
        driver.findElement(By.xpath(btnSearch)).click();
        String resultTest = driver.findElement(By.xpath(txtResult)).getText();

        System.out.println("El resultado de la pagina es: " + resultTest);
        readExcelFile.readExcel(fileExcelPath, "Hoja1");
        writeExcelFile.writeCellValue(fileExcelPath, "Hoja1", 0, 1, resultTest);       
        readExcelFile.readExcel(fileExcelPath, "Hoja1");


        Thread.sleep(2000);
        
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
