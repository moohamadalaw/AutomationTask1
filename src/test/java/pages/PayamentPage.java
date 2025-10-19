package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class PayamentPage {
    private WebDriver driver;

    private By cartNumber = By.id("account-cc");
    private By exp = By.id("exp-date");

    private By placeOrder = By.className("c-place-order__btn");
    public PayamentPage(WebDriver driver){
        this.driver = driver;
    }

    public void setCartNumber(String cartNumber) {
        driver.findElement(this.cartNumber).sendKeys(cartNumber);
    }

    public void setExp(String exp) {
        driver.findElement(this.exp).sendKeys(exp);
    }

    public void placeOrder(){
        driver.findElement(this.placeOrder).click();
    }
}
