package tests;

import base.BaseTest;
import pages.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ScreenshotUtil;

public class E2EFullFlow extends BaseTest {

    @Test
    public void testCompleteE2EFlow() throws Exception {

        // Test Data
        String firstName = "user";
        String lastName = "demo";
        String email = "user" + System.currentTimeMillis() + "@gmail.com";
        String password = "User@123";

        String productName = "14.1-inch Laptop";

        // Page Objects
        HomePage home = new HomePage(driver);
        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        OrderInfo orderInfo = new OrderInfo(driver);
        PdfInvoicePage invoice=new PdfInvoicePage(driver);

        // Register
        home.clickRegister();

        register.registerUser(
                "female",
                firstName,
                lastName,
                email,
                password,
                password
        );

        System.out.println("Registration completed");

        
        // Logout
        driver.findElement(By.linkText("Log out")).click();

        // Login
        home.clickLogin();
        login.login(email, password);

        System.out.println("Login successful");

        // Add Product
        home.addProductToCartFromHome(productName);
        ScreenshotUtil.captureScreenshot(driver, "product_added");

        Assert.assertTrue(product.isProductAddedToCart(), "Product not added to cart");

        // Cart
        cart.openCart();
        cart.selectCountry("India");
        cart.selectState("Other (Non US)");

        System.out.println("Cart updated");

        // Checkout
        checkout.acceptTerms();
        checkout.clickCheckout();

        String message = checkout.completeCheckoutFlow();

        Assert.assertTrue(message.toLowerCase().contains("successfully"), "Order not successful");

        System.out.println("ORDER PLACED SUCCESSFULLY");

        // ORDER VALIDATION
        orderInfo.openLatestOrderFromAccount();
        System.out.println("Opened latest order details");
        
        // Download Invoice
        invoice.downloadPdfInvoice();
        System.out.println("Invoice Downloaded Successfully");
    }
}