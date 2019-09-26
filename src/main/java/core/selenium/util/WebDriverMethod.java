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

import core.selenium.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
     * @param text       is the new value to send in sendKeys parameter.
     */
    public static void setTxtElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Finds webElement in DOM by locator css.
     *
     * @param webDriver  use to sut up the explicitWait of Driver.
     * @param elementCss use to search the webElement.
     * @return as boolean value equal true is whether is find the webElement.
     */
    public static boolean findElementInDom(final WebDriver webDriver, final String elementCss) {
        boolean result = false;
        final long time = 1;
        webDriver.
                manage().
                timeouts().
                implicitlyWait(time, TimeUnit.SECONDS);
        try {
            webDriver.findElement(By.cssSelector(elementCss));
            result = true;
            //TODO add log please, log in Atlassian page more
        } catch (NoSuchElementException e) {
            //TODO add log please, log in login page
        } finally {
            webDriver.
                    manage().
                    timeouts().
                    implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        }
        return result;
    }

    /**
     * Finds webElement that is clickable.
     *
     * @param webDriver  use to set up WebDriverWait.
     * @param webElement use to search the webElement.
     */
    public static void findElementBeClickable(final WebDriver webDriver, final WebElement webElement) {
        final long time = 1;
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, time);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException e) {
            throw new NullPointerException("Not found element" + webElement);
        } finally {
            webDriverWait = new WebDriverWait(webDriver, WebDriverConfig.getInstance().getExplicitWaitTime());
        }
    }
}
