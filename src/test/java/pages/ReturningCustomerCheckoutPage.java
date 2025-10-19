package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReturningCustomerCheckoutPage {
    private WebDriver driver;

    private By gustUserButton =  By.cssSelector("button[data-analytics-name='continue-as-guest']");

    public ReturningCustomerCheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickGustUserButton(){
        driver.findElement(gustUserButton).click();
    }

}
