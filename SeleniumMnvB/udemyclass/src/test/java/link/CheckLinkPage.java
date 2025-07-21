package link;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckLinkPage {
    
    private WebDriver driver;
    private String linkOptions = "//a[@data-testid='internal-link']";

    public CheckLinkPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean checkPageLink(){
        
        List<WebElement> link = driver.findElements(By.xpath(linkOptions));
        String url = "";
        List<String> brokenLink = new ArrayList<String>();
        List<String> okLink = new ArrayList<String>();
        int responseCode = 200;
        HttpURLConnection httpURLConnection = null;
        Iterator<WebElement> it = link.iterator();

        while (it.hasNext()) {
            url = it.next().getAttribute("href");

            if(url == null || url.isEmpty()){
                System.out.println(url+"No confi or empty");
            }

            try {
                httpURLConnection = (HttpURLConnection) (new URL(url).openConnection());
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();

                if(responseCode>400){
                    System.out.println("LINK NO VALIDA" + url);
                }
                else{
                    System.out.println("LINK VALIDO" + url);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Link validos" + okLink.size());
            System.out.println("Link invalidos" + brokenLink.size());

            if(brokenLink.size() > 0){
                System.out.println("Error");
                for(int i=0;i<brokenLink.size();i++){
                    System.out.println(brokenLink.get(i));
                }
                return false;
            }
        }  

        return true;
    }
}
