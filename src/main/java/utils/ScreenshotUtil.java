package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver, String fileName) {

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";
            File dest = new File(path);

            FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}