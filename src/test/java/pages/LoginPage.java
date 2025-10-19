package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    private WebDriver driver;
    private By email = By.cssSelector("input[id='email']");
    private By password = By.cssSelector("input[id='password']");

    private By login = By.className("login-button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isEmailVisaple(){
        if(driver.findElement(email).isDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    public void setEmail(String email){
        driver.findElement(this.email).sendKeys(email);
       }

    public void setPassword(String pass){
        driver.findElement(this.password).sendKeys(pass);
    }
    public void submit(){
        driver.findElement(login).click();
    }

}
