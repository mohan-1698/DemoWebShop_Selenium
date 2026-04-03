package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCart {

    WebDriver driver;
    WebDriverWait wait;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    }

    By shoppingCartLink = By.cssSelector("a.ico-cart");
    By successBar = By.id("bar-notification");
    By countryDropdown = By.id("CountryId");
    By stateDropdown = By.id("StateProvinceId");

    public void openCart() {

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(successBar));
        } catch (Exception e) {
            // Ignore if not present
        }

        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink)).click();
    }

    public void selectCountry(String countryName) {
        Select country = new Select(driver.findElement(countryDropdown));
        country.selectByVisibleText(countryName);
        System.out.println("Selected Country: " + countryName);
    }

    public void selectState(String stateName) {
        Select state = new Select(driver.findElement(stateDropdown));
        state.selectByVisibleText(stateName);
        System.out.println("Selected State: " + stateName);
    }
}