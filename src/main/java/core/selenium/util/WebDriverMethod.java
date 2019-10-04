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
import core.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * WebDriverMethod class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public final class WebDriverMethod {
    private static HashMap<String, By> byLocator = new HashMap<>();

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
     * @param webDriver   is the explicitWait of Driver.
     * @param locatorType is the type of the given locator.
     * @param locator     is the locator of the web element.
     * @return a boolean value equal true is whether is find the webElement.
     */
    public static boolean findElementInDom(final WebDriver webDriver, final String locatorType, final String locator) {
        boolean result = false;
        final long time = 1;
        webDriver.
                manage().
                timeouts().
                implicitlyWait(time, TimeUnit.SECONDS);
        try {
            fillMapAccordingLocator(locator);
            webDriver.findElement(byLocator.get(locatorType));
            result = true;
        } catch (NoSuchElementException e) {
            Log.getInstance().getLogger().info("Not found element: " + locator);
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
    public static void waitElementBeClickable(final WebDriver webDriver, final WebElement webElement) {
        final long time = 2;
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, time);
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (NoSuchElementException e) {
            throw new ElementClickInterceptedException("This element could not be clickable: " + webElement);
        }
    }

    /**
     * Waits for the text to be shown in the web element searched by class name.
     *
     * @param webDriverWait is the web driver wait of the used driver.
     * @param locatorType   is the type of the given locator.
     * @param locator       is the locator to find the web element. It should be by class.
     */
    public static void waitForATextInWebElement(final WebDriverWait webDriverWait, final String locatorType,
                                                final String locator) {
        webDriverWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                fillMapAccordingLocator(locator);
                return driver.findElement(byLocator.get(locatorType)).getText().length() != 0;
            }
        });
    }

    /**
     * Gets the text in given web element.
     *
     * @param webDriver   is the explicitWait of Driver.
     * @param locatorType is the type of the given locator.
     * @param locator     is the locator of the web element.
     * @return the text in web element.
     */
    public static String getTextInWebElement(final WebDriver webDriver, final String locatorType,
                                             final String locator) {
        fillMapAccordingLocator(locator);
        return webDriver.findElement(byLocator.get(locatorType)).getAttribute("textContent");
    }

    /**
     * Fills the by according to the locator.
     *
     * @param locator is the locator to be used.
     */
    private static void fillMapAccordingLocator(final String locator) {
        byLocator.put("className", By.className(locator));
        byLocator.put("css", By.cssSelector(locator));
        byLocator.put("id", By.id(locator));
    }

    /**
     * Creates a WebElement that is find in the DOM.
     *
     * @param driver      is to get the DOM.
     * @param locatorType is to type of locator to search a element.
     * @param locator     is to find the element into the DOM.
     * @return a object of Web IElement.
     */
    public static WebElement createWebElement(final WebDriver driver, final String locatorType, final String locator) {
        fillMapAccordingLocator(locator);
        return driver.findElement(byLocator.get(locatorType));
    }

    /**
     * Gets text of WebElement from a list parameter.
     *
     * @param webElements is to get their text.
     * @return as List all text from WebElement list.
     */
    public static List<String> getTextOfElements(final List<WebElement> webElements) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < webElements.size(); i++) {
            String textElement = (webElements.get(i).getText().replaceAll("@", ""));
            result.add(textElement);
        }
        return result;
    }

    /**
     * Gets the id of team from his url of team page.
     *
     * @param url is to get thi id of team.
     * @return as string the id of team.
     */
    public static String getIdTeam(final String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }
}
