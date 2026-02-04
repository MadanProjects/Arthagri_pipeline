package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ScreenshotUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() {
        driver = DriverFactory.initDriver();
        driver.get(config.ConfigReader.getProperty("baseUrl"));
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            String path =
                    ScreenshotUtils.takeScreenshot(scenario.getName());

            try {
                byte[] screenshot =
                        Files.readAllBytes(Paths.get(path));
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();
    }
}

