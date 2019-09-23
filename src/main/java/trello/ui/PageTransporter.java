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
 * @author Raul Choque
 * @version 0.0.1
 */
public class PageTransporter {

    /**
     * Navigate to URL use and and point.
     *
     * @param namePage use to complete the uri.
     */
    public static void navigateToURL(final String namePage) {
        try {
            WebDriver driver = WebDriverManager.getInstance().getWebDriver();
            driver.navigate().to(namePage);
        } catch (NullPointerException ex) {
            ex.printStackTrace();
            throw new NullPointerException("This url is not valid :" + ex.getMessage());
        }
    }
}
