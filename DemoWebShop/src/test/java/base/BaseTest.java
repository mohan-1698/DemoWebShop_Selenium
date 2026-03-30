package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;

    @BeforeSuite
    public void setup() {

        ChromeOptions options = new ChromeOptions();

        // 🔥 Disable autofill popup
        options.addArguments("--disable-autofill-keyboard-accessory-view");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");

        // 🔥 MAIN FIX (very important)
        options.addArguments("--disable-features=AutofillServerCommunication,PasswordManagerOnboarding");

        // 🔥 BEST PRACTICE (extra stability)
        options.addArguments("--incognito");

        // ✅ Initialize driver with options
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/");
    }

     
    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}