package tests;

import base.BaseTest;
import pages.ProductPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageAddCart extends BaseTest {

    @Test
    public void testAddProductFromHomePage() {

        // Step 1: Product name from homepage
        String productName = "14.1-inch Laptop";

        // Step 2: Click product directly from homepage
        driver.findElement(By.linkText(productName)).click();

        // Step 3: Product Page actions
        ProductPage productPage = new ProductPage(driver);

        productPage.clickAddToCart();

        // Step 4: Validation
        Assert.assertTrue(productPage.isProductAddedToCart(),
                "Product was not added to cart!");
    }
}