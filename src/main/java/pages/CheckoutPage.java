package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    String COUNTRY = "India";
    String CITY = "Vijayawada";
    String ADDRESS = "MG Road";
    String ZIP = "520001";
    String PHONE = "9876543210";


    // Cart Page
    By termsCheckbox = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");

    // Billing
    By billingDropdown = By.id("billing-address-select");
    By country = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By zip = By.id("BillingNewAddress_ZipPostalCode");
    By phone = By.id("BillingNewAddress_PhoneNumber");
    By billingContinue = By.cssSelector("#billing-buttons-container input.button-1");

    // Shipping Address
    By shippingDropdown = By.id("shipping-address-select");
    By shippingContinue = By.cssSelector("#shipping-buttons-container input.button-1");

    // Shipping Method
    By groundOption = By.id("shippingoption_0");
    By shippingMethodContinue = By.cssSelector("#shipping-method-buttons-container input.button-1");

    // Payment Method
    By codOption = By.id("paymentmethod_0");
    By paymentContinue = By.cssSelector("#payment-method-buttons-container input.button-1");

    // Payment Info
    By paymentInfoContinue = By.cssSelector("#payment-info-buttons-container input.button-1");

    // Confirm Order
    By confirmOrderBtn = By.cssSelector("#confirm-order-buttons-container input.button-1");

    // Success Page
    By successMessage = By.cssSelector(".order-completed .title");
    By successContinueBtn = By.cssSelector(".order-completed-continue-button");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void acceptTerms() {
        wait.until(ExpectedConditions.elementToBeClickable(termsCheckbox)).click();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }

    public void handleBilling() {

        System.out.println("Handling Billing...");

        List<WebElement> dropdownList = driver.findElements(billingDropdown);

        if (!dropdownList.isEmpty() && dropdownList.get(0).isDisplayed()) {

            System.out.println("Using existing billing address...");
            Select select = new Select(dropdownList.get(0));
            select.selectByIndex(0);
        }
        else {
            System.out.println("Filling new billing address...");
            wait.until(ExpectedConditions.visibilityOfElementLocated(country));
            new Select(driver.findElement(country)).selectByVisibleText(COUNTRY);
            driver.findElement(city).sendKeys(CITY);
            driver.findElement(address1).sendKeys(ADDRESS);
            driver.findElement(zip).sendKeys(ZIP);
            driver.findElement(phone).sendKeys(PHONE);
        }

        wait.until(ExpectedConditions.elementToBeClickable(billingContinue)).click();
    }

    public void handleShipping() {

        System.out.println("Handling Shipping...");
        List<WebElement> dropdownList = driver.findElements(shippingDropdown);
        if (!dropdownList.isEmpty() && dropdownList.get(0).isDisplayed()) {
            System.out.println("Using existing shipping address...");
            Select select = new Select(dropdownList.get(0));
            select.selectByIndex(0);
        }

        wait.until(ExpectedConditions.elementToBeClickable(shippingContinue)).click();
    }

    public String completeCheckoutFlow() {

        handleBilling();
        handleShipping();
        wait.until(ExpectedConditions.elementToBeClickable(groundOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(shippingMethodContinue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(codOption)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentContinue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentInfoContinue)).click();
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn)).click();

        String message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).getText();

        System.out.println("Order placed successfully!");

        wait.until(ExpectedConditions.elementToBeClickable(successContinueBtn)).click();

        System.out.println("Navigated to homepage after order");

        return message;
    }
}