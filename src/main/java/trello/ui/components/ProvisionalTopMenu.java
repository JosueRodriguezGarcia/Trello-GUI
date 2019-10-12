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

package trello.ui.components;

import core.selenium.WebDriverConfig;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

import java.util.concurrent.TimeUnit;

/**
 * ProvisionalTopMenu class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public class ProvisionalTopMenu extends BasePage {

    @FindBy(css = "a[class*='_1_raGOZzcyjACT']")
    private WebElement loginButton;

    @FindBy(className = "_1q-xxtNvcdFBca")
    private WebElement trelloLogo;

    /**
     * Verifies if there is the login button displayed in the page.
     *
     * @return true if the login button is displayed.
     */
    public boolean isLoginButtonDisplayed() {
        boolean answer = true;
        final long time = 2;
        driver.
                manage().
                timeouts().
                implicitlyWait(time, TimeUnit.SECONDS);
        try {
            loginButton.getText();
        } catch (NoSuchElementException nsee) {
            answer = false;
        } finally {
            driver.
                    manage().
                    timeouts().
                    implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        }
        return answer;
    }

    /**
     * Waits until that element is loaded.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(trelloLogo));
    }
}
