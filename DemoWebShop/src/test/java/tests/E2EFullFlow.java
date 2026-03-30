package tests;

import base.BaseTest;
import pages.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class E2EFullFlow extends BaseTest {

    @Test
    public void testCompleteE2EFlow() {

        // 🔥 Test Data
        String firstName = "Test";
        String lastName = "User";
        String email = "testuser" + System.currentTimeMillis() + "@mail.com";
        String password = "Test@123";

        String productName = "14.1-inch Laptop";

        // 🔥 Page Objects
        HomePage home = new HomePage(driver);
        RegisterPage register = new RegisterPage(driver);
        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);
        CheckoutPage checkout = new CheckoutPage(driver);
        OrderInfo orderInfo = new OrderInfo(driver); // ⭐ NEW

        // ============================
        // 🔹 STEP 1: Register
        // ============================
        home.clickRegister();

        register.registerUser(
                "male",
                firstName,
                lastName,
                email,
                password,
                password
        );

        System.out.println("✅ Registration completed");

        // ============================
        // 🔹 STEP 2: Logout
        // ============================
        driver.findElement(By.linkText("Log out")).click();

        // ============================
        // 🔹 STEP 3: Login
        // ============================
        home.clickLogin();
        login.login(email, password);

        System.out.println("✅ Login successful");

        // ============================
        // 🔹 STEP 4: Add Product
        // ============================
        home.addProductToCartFromHome(productName);

        Assert.assertTrue(product.isProductAddedToCart(),
                "❌ Product not added to cart");

        // ============================
        // 🔹 STEP 5: Cart
        // ============================
        cart.openCart();
        cart.selectCountry("India");
        cart.selectState("Other (Non US)");

        System.out.println("✅ Cart updated");

        // ============================
        // 🔹 STEP 6: Checkout
        // ============================
        checkout.acceptTerms();
        checkout.clickCheckout();

        String message = checkout.completeCheckoutFlow();

        Assert.assertTrue(message.toLowerCase().contains("successfully"),
                "❌ Order not successful");

        System.out.println("🎉 ORDER PLACED SUCCESSFULLY");

        // ============================
        // 🔥 STEP 7: ORDER VALIDATION (NEW)
        // ============================
        orderInfo.openLatestOrderFromAccount();

        System.out.println("✅ Opened latest order details");
    }
}