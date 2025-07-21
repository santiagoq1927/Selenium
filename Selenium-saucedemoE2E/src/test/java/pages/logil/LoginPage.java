package pages.logil;

import pages.BasePage;

public class LoginPage extends BasePage{

    private String inpUsername = "//input[@id='user-name']";
    private String inpPassword = "//input[@id='password']";
    private String btnLogin = "//input[@id='login-button']";

    public LoginPage(){
        super(driver);
    }

    public void navigateToSaucedemo(){
        navigateTo("https://www.saucedemo.com/");
    }
    
    public void enterUsername(String username){
        write(inpUsername, username);
    }

    public void enterPassword(String password){
        write(inpPassword, password);
    }

    public void selectLogin(){
        clickElement(btnLogin);
    }

    public void enterLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        selectLogin();
    }

}
