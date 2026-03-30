package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

   
    @Test
    public void validLoginTest() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

       loginPage.login("samanvitha123@gmail.com", "samanvitha123");

        System.out.println("Valid Login Test Passed");
    }
    
    @Test
    public void invalidLoginTest() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLogin();

       loginPage.login("samanvitha123@gmail.com", "samanvitha23");
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       String errorMsg = wait.until(
           ExpectedConditions.visibilityOfElementLocated(By.className("validation-summary-errors"))
       ).getText();

       Assert.assertTrue(errorMsg.contains("Login was unsuccessful"));

        System.out.println("Invalid Login Test Passed");
    }
    
}