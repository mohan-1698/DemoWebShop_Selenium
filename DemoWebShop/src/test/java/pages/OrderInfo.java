package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class OrderInfo {

    WebDriver driver;
    WebDriverWait wait;

    public OrderInfo(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 🔥 Locators
    By accountLink = By.cssSelector("a.account");
    By ordersLink = By.cssSelector("a[href='/customer/orders']");
    By orderDetailsButtons = By.cssSelector("input.order-details-button");

    // ============================
    // 🔹 Step 1: Go to My Account
    // ============================
    public void goToMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        System.out.println("Navigated to My Account");
    }

    // ============================
    // 🔹 Step 2: Go to Orders Page
    // ============================
    public void goToOrders() {
        wait.until(ExpectedConditions.elementToBeClickable(ordersLink)).click();
        System.out.println("Navigated to Orders page");
    }

    // ============================
    // 🔹 Step 3: Click Latest Order Details
    // ============================
    public void openLatestOrderDetails() {

        List<WebElement> orders = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(orderDetailsButtons)
        );

        if (!orders.isEmpty()) {
            orders.get(0).click(); // latest order (top one)
            System.out.println("Opened latest order details");
        } else {
            System.out.println("❌ No orders found");
        }
    }

    // ============================
    // 🔹 Combined Flow (BEST)
    // ============================
    public void openLatestOrderFromAccount() {
        goToMyAccount();
        goToOrders();
        openLatestOrderDetails();
    }
}