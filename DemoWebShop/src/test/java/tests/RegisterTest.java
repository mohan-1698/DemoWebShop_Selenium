package tests;

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
                "female",
                "Vaishnavi",
                "Perumalla",
                email,
                "Password123",
                "Password123"
        );
        System.out.println("Registration Successful");
    }
}