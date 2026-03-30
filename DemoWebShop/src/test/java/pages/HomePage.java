package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Existing locator
    By registerLink=By.linkText("Register");
	public RegisterPage clickRegister() {
        driver.findElement(registerLink).click();
        return new RegisterPage(driver);
    }
	By loginLink = By.linkText("Log in");

    public LoginPage clickLogin() {
        driver.findElement(loginLink).click();
        return new LoginPage(driver);
}

    // 🔥 NEW: Add product directly from homepage
    public void addProductToCartFromHome(String productName) {

        List<WebElement> products = driver.findElements(By.cssSelector(".product-item"));

        for (WebElement product : products) {

            String name = product.findElement(By.cssSelector(".product-title a")).getText();

            if (name.equalsIgnoreCase(productName)) {

                product.findElement(
                        By.cssSelector("input.button-2.product-box-add-to-cart-button")
                ).click();

                System.out.println("Added from homepage: " + name);
                return;
            }
        }

        System.out.println("❌ Product not found on homepage: " + productName);
    }

  
}