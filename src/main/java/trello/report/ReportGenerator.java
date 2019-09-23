/*
 * @(#) GeneratorReport.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package trello.report;

import core.selenium.util.PropertiesReader;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static trello.keys.Constants.BROWSER_NAME;
import static trello.keys.Constants.PATH_GRADLE_PROPERTIES_FILE;

/**
 * ReportGenerator class is in charge of generate the test utils.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public final class ReportGenerator {

    /**
     * Private constructor requested by checkstyle.
     */
    private ReportGenerator() {

    }

    /**
     * Sets up and creates the cucumber report.
     */
    public static void generateReport() {
       Properties properties = PropertiesReader.getProperties(PATH_GRADLE_PROPERTIES_FILE);
        final File reportOutputDirectory = new File("target");
        final List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");
        final String projectName = "Trello-GUI";
        final boolean runWithJenkins = false;
        final Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // additional metadata presented on main page
        configuration.addClassifications("Platform", "Windows 10");
        configuration.addClassifications("Browser", properties.getProperty(BROWSER_NAME));
        configuration.addClassifications("Branch", "RELEASE/1.0");
        final ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        final Reportable result = reportBuilder.generateReports();
        // and here validate 'result' to decide what to do if utils has failed
    }
}
