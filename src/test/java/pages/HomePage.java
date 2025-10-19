package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.Constant.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static utility.Constant.URL;

public class HomePage {
    private WebDriver driver;

    private By AccountButton = By.xpath("//*[@id=\"my-account-button\"]/button/span");
    private By SignIn = By.className("sign-in---register");

    private By signOut = By.className("sign-out");

    private By searchBox = By.id("search-0");

    private By submitSearch = By.xpath("//*[@id=\"app-header\"]/header/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div[1]/form/div/div[3]/button");

    private By cart = By.className("qa-header__cart");
    private By closeCookieButton = By.className("c-cookie-banner__close-button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String product) {
        driver.findElement(searchBox).sendKeys(product);
        driver.findElement(submitSearch).click();
    }
    public void openHomePage(){
        driver.get(URL);
    }

    public boolean Welcome(){
        System.out.println("Welcome");
        return true;
    }
    public boolean isLoginButtonIsVisable(){
        return driver.findElement(SignIn).isDisplayed();
    }
    public void goToLoginPage(){
        driver.findElement(SignIn).click();
    }
    public void hoverOnSignIn() {
        WebElement signInElement = driver.findElement(AccountButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(signInElement).perform();
        System.out.println("Hovered on Sign In button");
    }

    public boolean isLoginSuccess(){
        WebElement signInElement = driver.findElement(AccountButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(signInElement).perform();

        if(driver.findElement(signOut).isDisplayed()){
            return true ;
        }
        return false;

    }
    public void goToCart(){
        driver.findElement(cart).click();
        driver.get("https://certwcs.frontgate.com/ShoppingCartView");
    }

    public void closeCookieSection(){
        driver.findElement(closeCookieButton).click();
    }
}