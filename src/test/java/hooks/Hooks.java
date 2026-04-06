package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ScreenshotUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp() {

        // Always get driver from factory
        driver = DriverFactory.initDriver();

        driver.get(config.ConfigReader.getProperty("baseUrl"));

        // Centralized login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                config.ConfigReader.getProperty("username"),
                config.ConfigReader.getProperty("password")
        );
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            String path = ScreenshotUtils.takeScreenshot(scenario.getName());

            try {
                byte[] screenshot = Files.readAllBytes(Paths.get(path));
                scenario.attach(screenshot, "image/png", scenario.getName());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // ✅ ONLY ONE QUIT METHOD
        DriverFactory.quitDriver();
    }
}