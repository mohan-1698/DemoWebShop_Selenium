package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;

    By genderMale = By.id("gender-male");
    By genderFemale = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");

    // 🔥 NEW: Continue button
    By continueBtn = By.cssSelector(".register-continue-button");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMale).click();
        } else {
            driver.findElement(genderFemale).click();
        }
    }

    public void setFirstName(String firstName) {
        driver.findElement(this.firstName).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(this.email).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(this.confirmPassword).sendKeys(confirmPassword);
    }

    public void setRegisterBtn() {
        driver.findElement(this.registerBtn).click();
    }

    // 🔥 NEW METHOD
    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void registerUser(String gender, String fname, String lname, String mail, String pwd, String cpwd) {

        selectGender(gender);
        setFirstName(fname);
        setLastName(lname);
        setEmail(mail);
        setPassword(pwd);
        setConfirmPassword(cpwd);
        setRegisterBtn();

        // 🔥 NEW: click continue after registration
        clickContinue();
    }
}