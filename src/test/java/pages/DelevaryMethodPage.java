package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DelevaryMethodPage {
    private WebDriver driver;
    private By PayamentButtonPage = By.id("nextBtn");

    public DelevaryMethodPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToPaymentMethod(){
        driver.findElement(PayamentButtonPage).click();
    }

}
