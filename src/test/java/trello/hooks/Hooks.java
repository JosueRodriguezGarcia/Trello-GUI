/*
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package trello.hooks;


import core.selenium.WebDriverManager;
import core.utils.Log;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Hooks class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class Hooks {

    private WebDriver webDriver;

    /**
     * This method is used for initializes the variables.
     */
    public Hooks() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    /**
     * Does a screenshot when the scenario is failed.
     *
     * @param scenario defines a input scenario to be review.
     */
    @After
    public void endTest(final Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                Log.getInstance().getLogger().error(e + " Scenario is Failed");
                throw new WebDriverException();
            }
        }
    }
}
