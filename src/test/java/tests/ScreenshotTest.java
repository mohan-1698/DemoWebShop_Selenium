package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ScreenshotUtil;

public class ScreenshotTest extends BaseTest {

    @Test
    public void captureHomePageScreenshot() {
        ScreenshotUtil.captureScreenshot(driver, "homepage");
        System.out.println("Screenshot of homepage captured");
    }
    
    @Test
    public void captureAfterLoginClick() {
        driver.findElement(By.linkText("Log in")).click();
        ScreenshotUtil.captureScreenshot(driver, "login_page");
        System.out.println("Login page screenshot captured");
    }
}