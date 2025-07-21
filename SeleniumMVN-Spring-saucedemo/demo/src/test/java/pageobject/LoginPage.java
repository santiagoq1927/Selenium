// package pageobject;

// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.FindBy;

// import constantsglobal.ConstantsGeneral;


// public class LoginPage {
    
//     @FindBy(xpath = ConstantsGeneral.INPUT_USERNAME)
//     private WebElement inpUserName;

//     public WebElement getInputUserName(){
//         return inpUserName;
//     }

//     @FindBy(xpath = ConstantsGeneral.INPUT_PASSWORD)
//     private WebElement inpPassword;

//     public WebElement getInputPassword(){
//         return inpPassword;
//     }

//     @FindBy(xpath = ConstantsGeneral.BUTTON_LOGIN)
//     private WebElement btnLogin;

//     public WebElement getButtonLogin(){
//         return btnLogin;
//     }

//     public void enterUserName(String username){
//         inpUserName.sendKeys(username);
//     }

//     public void enterPassword(String password){
//         inpPassword.sendKeys(password);
//     }

//     public void selectLogin(){
//         btnLogin.click();
//     }

//     public void Login(String username, String password){
//         this.enterUserName(username);
//         this.enterPassword(password);
//         this.selectLogin();
//     }



// }
