/*
 * @(#) IBrowser.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package core.selenium.webdrivers;

import org.openqa.selenium.WebDriver;

/**
 * IBrowser interface.
 *
 * @author Josue Rodriguez Garcia
 * @version 0.0.1
 */
public interface IBrowser {

    /**
     * This method defines the behavior for browser.
     *
     * @return a IBrowser
     */
    WebDriver initDriver();
}
