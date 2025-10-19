package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProdactDetailesPage   {

    private WebDriver driver;

    private By productName = By.className("t-universal-product-details-heading-info__title");
    private By productPrice = By.className("price");
    private By productImage = By.className("c-image");
    private By addToCartButton = By.className("c-universal-add-to-cart");


    private  By options = By.cssSelector(".c-universal-options__option-swatch-container");



    public void clickButtonRequiredOptionGroups() {
        By optionGroups = By.cssSelector(".c-universal-options__option");

        List<WebElement> groups = driver.findElements(optionGroups);

        for (int i = 0; i < groups.size(); i++) {
            WebElement group = groups.get(i);
            try {
                if (group.isDisplayed()) {
                    WebElement firstDiv = group.findElement(By.cssSelector(".c-universal-options__option-swatch-container"));

                    WebElement button = firstDiv.findElement(By.tagName("button"));

                    if (button.isDisplayed() && button.isEnabled()) {
                        button.click();
                        Thread.sleep(2000);
                    }

                }
            } catch (Exception e) {
            }
        }
    }

    public void selectFirstOptionFromEachGroup() {
        By optionGroups = By.cssSelector(".c-universal-options__option");

        List<WebElement> groups = driver.findElements(optionGroups);




        System.out.println("عدد المجموعات = " + groups.size());

        for (WebElement group : groups) {
            try {
                WebElement firstOption = null;

                List<WebElement> clickableOptions = group.findElements(By.cssSelector(
                        "button, .c-universal-options__option-swatch-container, img, div"));

                for (WebElement option : clickableOptions) {
                    if (option.isDisplayed() && option.isEnabled()) {
                        firstOption = option;
                        break;
                    }
                }

                if (firstOption != null) {
                    firstOption.click();
                } else {
                }

            } catch (Exception e) {
            }
        }
    }


    public ProdactDetailesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public boolean isProductNameDisaple() {
        return driver.findElement(productName).isDisplayed();
    }

    public boolean isProductPriceDisaple() {
        return driver.findElement(productPrice).isDisplayed();
    }

    public boolean isProductImageDisaple() {
        return driver.findElement(productImage).isDisplayed();
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void addToCart() throws InterruptedException{
        Thread.sleep(2000);
        WebElement addToCart = driver.findElement(addToCartButton);

        if (addToCart.isDisplayed()) {
        clickButtonRequiredOptionGroups();
        }
        clickAddToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("c-items-added-to-cart")));

        driver.findElement(By.className("view-cart-btn")).click();

        Thread.sleep(10000);

    }
}

