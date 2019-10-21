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

package core.selenium;

import core.selenium.webdrivers.Chrome;
import core.selenium.webdrivers.FireFox;
import core.selenium.webdrivers.IBrowser;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the logic for select a browser.
 *
 * @author Josue Rodriguez Garcia
 * @version 0.0.1
 */
public final class WebDriverFactory {
    private static Map<String, IBrowser> browsers = new HashMap<>();
    static {
        browsers.put("CHROME", new Chrome());
        browsers.put("FIREFOX", new FireFox());
    }

    /**
     * Private constructor requested by checkstyle.
     */
    private WebDriverFactory() {

    }

    /**
     * This method is used for select a Browser.
     *
     * @param browser The browser parameter defines a input Browser
     * @return a webDriver.
     */
    public static WebDriver getWebDriver(final String browser) {
        return browsers.get(browser).initDriver();
    }
}
