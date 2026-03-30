package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.ExcelUtil;

public class LoginTest extends BaseTest {
	
	@DataProvider(name = "loginData")
	public Object[][] getData() {
	    String path = "src/test/resources/testdata/LoginData.xlsx";
	    return ExcelUtil.getTestData(path, "Sheet1");
	}
	
	@Test(dataProvider = "loginData")
	public void loginTest(String email, String password) {

	    HomePage homePage = new HomePage(driver);
	    LoginPage loginPage = homePage.clickLogin();

	    loginPage.login(email, password);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    // Check if login successful
	    if (driver.findElements(By.linkText("Log out")).size() > 0) {

	        System.out.println("Login SUCCESS for: " + email);

	        // logout for next iteration
	        driver.findElement(By.linkText("Log out")).click();

	    } else {
	    	String errorMsg = wait.until(
	    		    ExpectedConditions.visibilityOfElementLocated(
	    		        By.className("validation-summary-errors"))
	    		).getText();
	    		System.out.println("Login FAILED for: " + email);
	    		System.out.println("Error: " + errorMsg);
	    }
	}
}