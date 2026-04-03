package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		 this.driver = driver;
	
	} 
	By email = By.id("Email");
	By password = By.id("Password");
	By loginButton = By.xpath("//input[@value='Log in']");
	 
	public void enterEmail(String userEmail) {
	driver.findElement(email).clear();
	driver.findElement(email).sendKeys(userEmail);
	}
				 
    public void enterPassword(String userPassword) {
	driver.findElement(password).clear();
    driver.findElement(password).sendKeys(userPassword);
    }
				 
	public void clickLogin() {
    driver.findElement(loginButton).click();
    
	 }
	public void login(String userEmail, String userPassword) {
	enterEmail(userEmail);
	enterPassword(userPassword);
	clickLogin();
	}
}