/*
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package runner;

import core.selenium.WebDriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import trello.api.EnvironmentSetup;
import trello.report.ReportGenerator;

/**
 * RunCukesTest class.
 *
 * @author Melissa Román
 * @version 1.0
 */
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json"},
        glue = {"trello/steps", "trello/hooks"},
        features = {"src/test/resources/features"},
        monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {

    @BeforeTest
    public void beforeExecution(){
        EnvironmentSetup.getInstance().setEnvironmentSetup();
    }
    /**
     * Generates de utils after the test execution. Also quits from the browser.
     */
    @AfterTest
    public void afterExecution() {
        ReportGenerator.generateReport();
        EnvironmentSetup.getInstance().delete();
        WebDriverManager.getInstance().getWebDriver().quit();
    }
}
