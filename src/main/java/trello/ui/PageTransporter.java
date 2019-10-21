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

package trello.ui;

import core.selenium.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * PageTransporter class.
 *
 * @author Raul Choque, Josue Rodriguez
 * @version 0.0.1
 */
public final class PageTransporter {

    private static WebDriver driver = WebDriverManager.getInstance().getWebDriver();

    /**
     * Private constructor requested by checkstyle.
     */
    private PageTransporter() {

    }

    /**
     * Navigate to URL use and and point.
     *
     * @param namePage use to complete the uri.
     */
    public static void navigateToURL(final String namePage) {
        try {
            driver.navigate().to(namePage);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            throw new NullPointerException("This url is not valid :" + ex.getMessage());
        }
    }

    /**
     * Gets the current url.
     *
     * @return a String with the current url.
     */
    public static String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Goes the back page.
     */
    public static void goBackPage() {
        driver.navigate().back();
    }

    /**
     * Goes the forward page.
     */
    public static void goForwardPage() {
        driver.navigate().forward();
    }

    /**
     * Refreshes the current Page.
     */
    public static void refreshPage() {
        driver.navigate().refresh();
    }
}
