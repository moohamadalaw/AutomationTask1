package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;


import java.time.Duration;

public class WelcomeTest extends BaseTest {
    HomePage HP;

    @BeforeMethod
    public void setupPage(){
        HP = new HomePage(driver);
        HP.openHomePage();
    }

    @Test
    public void testE2E_CreateOrderFlow() throws InterruptedException {
        // Go TO Login Page
        Assert.assertTrue(HP.Welcome());
        HP.hoverOnSignIn();
        Assert.assertTrue(HP.isLoginButtonIsVisable());
        HP.goToLoginPage();

        HP.closeCookieSection();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        // Login Functionality
        LoginPage LP = new LoginPage(driver);
        LP.isEmailVisaple();
        LP.setEmail("malawnah2003@gmail.com");
        LP.setPassword("Mohammad123@");
        LP.submit();

        // Verify Login
        HP = new HomePage(driver);
        Thread.sleep(4000);
        Assert.assertTrue(HP.isLoginSuccess());


        // Search Product
        HP.search("Flowers");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mainContentTitle")));
        Thread.sleep(6000);



        // Product List Page
        ProductListPage PLP = new ProductListPage(driver);
        PLP.GoToPDP();

        Thread.sleep(6000);


        // Product Detailes Page
        ProdactDetailesPage PDP = new ProdactDetailesPage(driver);
        PDP.addToCart();

        // Cart Page
        CartPage CP = new CartPage(driver);
        CP.goTOCheckoutPage();
        Thread.sleep(10000);


        // Shipping page
        ShippingPage SP = new ShippingPage(driver);
        SP.goToDeliveryMethod();
        Thread.sleep(10000);

        // Delevery Method Page
        DelevaryMethodPage DP = new DelevaryMethodPage(driver);
        DP.goToPaymentMethod();

        Thread.sleep(9000);


        // Payament Page
        PayamentPage PM = new PayamentPage(driver);
        PM.setCartNumber("4000060000000006");
        PM.setExp("03/30");
        Thread.sleep(6000);
        PM.placeOrder();
        Thread.sleep(9000);


        // Order Confirm Page
        OrderConfirmPage OCP = new OrderConfirmPage(driver);
        Assert.assertTrue(OCP.confirmEmail());

    }
}