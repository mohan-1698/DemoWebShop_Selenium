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

    By accountLink = By.cssSelector("a.account");
    By ordersLink = By.cssSelector("a[href='/customer/orders']");
    By orderDetailsButtons = By.cssSelector("input.order-details-button");

    public void goToMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(accountLink)).click();
        System.out.println("Navigated to My Account");
    }

    public void goToOrders() {
        wait.until(ExpectedConditions.elementToBeClickable(ordersLink)).click();
        System.out.println("Navigated to Orders page");
    }

    public void openLatestOrderDetails() {
        List<WebElement> orders = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(orderDetailsButtons)
        );
        if (!orders.isEmpty()) {
            orders.get(0).click();
            System.out.println("Opened latest order details");
        } else {
            System.out.println("No orders found");
        }
    }

    public void openLatestOrderFromAccount() {
        goToMyAccount();
        goToOrders();
        openLatestOrderDetails();
    }
}