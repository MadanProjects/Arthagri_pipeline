package hooks;

import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import utils.ExtentManager;

public class ExtentHooks {

    private static ExtentTest test;

    @Before
    public void startScenario(Scenario scenario) {
        test = ExtentManager.getExtent()
                .createTest(scenario.getName());
    }

    @After
    public void endScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.fail("Scenario Failed");
        } else {
            test.pass("Scenario Passed");
        }
        ExtentManager.getExtent().flush();
    }

    public static ExtentTest getTest() {
        return test;
    }
}

