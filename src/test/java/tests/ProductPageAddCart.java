package tests;

import base.BaseTest;
import pages.ProductPage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageAddCart extends BaseTest {

    @Test
    public void testAddProductFromHomePage() {

        String productName = "14.1-inch Laptop";
        driver.findElement(By.linkText(productName)).click();

        ProductPage productPage = new ProductPage(driver);
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.isProductAddedToCart(),"Product was not added to cart!");
    }
}