package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By CheckOutButton = By.className("c-checkout-buttons__checkout");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }


    public void goTOCheckoutPage(){
        driver.findElement(CheckOutButton).click();
    }

}
