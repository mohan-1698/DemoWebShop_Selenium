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

        HomePage home = new HomePage(driver);
        ProductPage product = new ProductPage(driver);
        ShoppingCart cart = new ShoppingCart(driver);

        String productName = "14.1-inch Laptop";

        home.addProductToCartFromHome(productName);

        Assert.assertTrue(product.isProductAddedToCart(),
                "Product not added before opening cart!");

        cart.openCart();

        cart.selectCountry("India");

        cart.selectState("Other (Non US)");

        System.out.println("Cart country & state selection successful");
    }
}