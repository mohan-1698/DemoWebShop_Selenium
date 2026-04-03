package pages;

import org.openqa.selenium.*;
import java.util.List;

public class CategoryPage {

    WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        
    }

    public void openCategory(String categoryName) {
        driver.findElement(By.linkText(categoryName)).click();
    }

    public void openSubCategory(String subCategoryName) {
        driver.findElement(By.linkText(subCategoryName)).click();
    }

    public boolean isOnCategoryPage(String categoryName) {
        String currentUrl = driver.getCurrentUrl().toLowerCase();
        String formattedCategory = categoryName
                .toLowerCase()
                .replace("&", "")
                .replace(" ", "-");
        return currentUrl.contains(formattedCategory);
    }

    public void addProductToCartByName(String productName) {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));
        for (WebElement product : products) {
            String name = product.findElement(By.cssSelector(".product-title a")).getText();
            if (name.equalsIgnoreCase(productName)) {
                product.findElement(
                        By.cssSelector("input.button-2.product-box-add-to-cart-button")
                ).click();
                System.out.println("Added product: " + name);
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }
}