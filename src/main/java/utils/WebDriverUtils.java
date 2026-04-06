package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class WebDriverUtils {

    public static void scrollToElement(WebDriver driver, By locator, int waitTime) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(locator));
    }
}