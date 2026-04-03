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

        options.addArguments("--disable-autofill-keyboard-accessory-view");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-features=AutofillServerCommunication,PasswordManagerOnboarding");
        options.addArguments("--incognito");
 
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        
        

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