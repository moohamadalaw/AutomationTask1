package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmPage {
    private WebDriver driver;
    private By ThankYouMessage = By.className("t-checkout-confirmation__thank-you-widget__thank-message");

    public OrderConfirmPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean confirmEmail(){
        return driver.findElement(ThankYouMessage).isDisplayed();
    }

}
