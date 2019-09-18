/*
 * @(#) WedDriverConfig.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package core.selenium;

import core.selenium.util.PropertiesReader;
import core.selenium.webdrivers.BrowserType;

import java.util.Properties;

/**
 * This class reads the gradle.properties file.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public final class WebDriverConfig {
    private static final String PROPERTIES_FILE = "webdriver.properties";
    private static WebDriverConfig webDriverConfig;
    private Properties properties;
    private static final String BROWSER_NAME = "browser";
    private static final String IMPLICIT_WAIT_TIME = "implicitly-wait";
    private static final String EXPLICIT_WAIT_TIME = "explicitly-wait";
    private static final String SLEEP_TIME = "sleep-time";

    /**
     * This is constructor for init variables.
     */
    private WebDriverConfig() {
        initializes();

    }

    /**
     * This method ensure that only one instance is created according to the build pattern.
     *
     * @return an instance of 'WebDriverConfig' type.
     */
    public static WebDriverConfig getInstance() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    /**
     * This method reads the file 'gradle.properties' ans return its values through the object 'properties'.
     */
    private void initializes() {
        properties = PropertiesReader.getProperties(PROPERTIES_FILE);
    }

    /**
     * Gives the browser properties read from 'gradle.properties'.
     *
     * @return a browser.
     */
    public BrowserType getBrowser() {
        return BrowserType.valueOf(properties.getProperty(BROWSER_NAME).toUpperCase());
    }

    /**
     * Gives the implicitly wait properties read from 'gradle.properties'.
     *
     * @return a implicitly wait.
     */
    public long getImplicitlyWaitTime() {
        return Long.parseLong(properties.getProperty(IMPLICIT_WAIT_TIME));
    }

    /**
     * Gives the explicitly wait properties read from 'gradle.properties'.
     *
     * @return a explicitly wait.
     */
    public long getExplicitlWaitTime() {
        return Long.parseLong(properties.getProperty(EXPLICIT_WAIT_TIME));
    }

    /**
     * Gives the wait sleep properties read from 'gradle.properties'.
     *
     * @return a explicitly wait.
     */
    public long getSleepWait() {
        return Long.parseLong(properties.getProperty(SLEEP_TIME));
    }
}
