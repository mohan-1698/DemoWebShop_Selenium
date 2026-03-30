package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openProduct(String productName) {
        driver.findElement(By.linkText(productName)).click();
    }

    public void clickAddToCart() {
        WebElement addToCartBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("input[id^='add-to-cart-button']")
                )
        );
        addToCartBtn.click();
    }

    public void openProductAndAddToCart(String productName) {
        openProduct(productName);
        clickAddToCart();
    }

    public boolean isProductAddedToCart() {
        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".bar-notification.success")
                )
        );
        return successMsg.isDisplayed();
    }
}