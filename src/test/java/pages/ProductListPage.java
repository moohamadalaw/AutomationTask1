package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ProductListPage {
    private WebDriver driver;

    private By productLinks = By.cssSelector(".c-product-list-products__product-card a.c-link.u-w-100");

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }



    public void GoToPDP() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLinks));

        List<WebElement> products = driver.findElements(productLinks);

        if (products.isEmpty()) {
            throw new RuntimeException("No products found on the Product List Page!");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(products.size());

        products.get(randomIndex).click();
    }
}
