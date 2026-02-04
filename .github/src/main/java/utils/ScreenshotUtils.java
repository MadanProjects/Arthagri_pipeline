package utils;

import driver.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(String scenarioName) {

        WebDriver driver = DriverFactory.getDriver();

        String timestamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        String screenshotPath =
                System.getProperty("user.dir") +
                "/target/screenshots/" +
                scenarioName + "_" + timestamp + ".png";

        try {
            File srcFile =
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot");
        }

        return screenshotPath;
    }
}
