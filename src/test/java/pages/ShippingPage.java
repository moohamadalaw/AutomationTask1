package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage {

    private WebDriver driver;
    private By continueToDeliveryMethodButton = By.id("shipping-next-btn");

    public ShippingPage(WebDriver driver){
        this.driver = driver;
    }
    public void goToDeliveryMethod(){
        driver.findElement(continueToDeliveryMethodButton).click();
    }
}