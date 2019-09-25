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

package core.selenium.util;

import core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * WebDriverMethod class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public final class WebDriverMethod {

    /**
     * Private constructor requested by checkstyle.
     */
    private WebDriverMethod() {

    }

    /**
     * Sets text in the WebElement object.
     *
     * @param webElement to set its text.
     * @param text is the new value to send in sendKeys parameter.
     */
    public static void setTxtElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static boolean isElementPresent(final WebDriver webDriver, WebDriverWait wait,  final By elementBy) {
        wait = new WebDriverWait(webDriver, 5);
        boolean isDisplayed;
        try {
            webDriver.findElement(elementBy);
            isDisplayed = true;
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        } finally {
            wait = WebDriverManager.getInstance().getWebDriverWait();
        }
        return isDisplayed;
    }
}
