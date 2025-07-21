package page;

public class LoginWhitBasePage extends BasePage{

    private String inpUserName = "//input[@id='user-name']";
    private String intPassword = "//input[@id='password']";
    private String btnLogin = "//input[@id='login-button']";

    public LoginWhitBasePage(){
        super(driver);
    }

    public void navigateToSouce(){
        navigateTo("https://www.saucedemo.com/");
    }

    public void enterUsername(String username){
        write(inpUserName, username);
    }

    public void enterPassword(String password){
        write(intPassword, password);
    }

    public void selectLogin(){
        clickElement(btnLogin);
    }

    public void toLogin(String username, String password){
        enterUsername(username);
        enterPassword(password);
        selectLogin();
    }


    
}
