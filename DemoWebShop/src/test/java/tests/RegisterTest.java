package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyUserRegistration() {

        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = homePage.clickRegister();

        String email = "test" + System.currentTimeMillis() + "@gmail.com";

        registerPage.registerUser(
                "male",
                "Mohan",
                "Test",
                email,
                "Password123",
                "Password123"
        );

        String successMsg = driver.findElement(By.className("result")).getText();

        Assert.assertEquals(successMsg, "Your registration completed");

        System.out.println("Registration Successful: " + successMsg);
    }
}