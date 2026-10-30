package com.latha.saucedemo.support;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Runs after every scenario: attaches a screenshot to the report if it failed,
 * then closes the browser.
 */
public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot at failure");
            }
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
