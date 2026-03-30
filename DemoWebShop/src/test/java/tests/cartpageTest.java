package tests;

import base.BaseTest;
import pages.ShoppingCart;
import pages.HomePage;
import pages.ProductPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class cartpageTest extends BaseTest {

    @Test
    public void testCartCountryAndStateSelection() {

        // 🔥 Step 1: Add product first (cart must not be empty)
        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);

        String productName = "14.1-inch Laptop";

        home.addProductToCartFromHome(productName);

        Assert.assertTrue(product.isProductAddedToCart(),
                "Product not added before opening cart!");

        // 🔥 Step 2: Open Cart
        cart.openCart();

        // 🔥 Step 3: Select Country
        cart.selectCountry("India");

        // 🔥 Step 4: Select State
        cart.selectState("Other (Non US)");

        System.out.println("✅ Cart country & state selection successful");
    }
}