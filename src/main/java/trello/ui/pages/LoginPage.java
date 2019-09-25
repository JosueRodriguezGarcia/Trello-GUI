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

package trello.ui.pages;

import core.selenium.WebDriverConfig;
import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entities.User;

import java.util.concurrent.TimeUnit;

/**
 * LoginPage class.
 *
 * @author Raul Choque, Josue Rodriguez Garcia
 * @version 0.0.1
 */
public class LoginPage extends BasePage {
    @FindBy(id = "user")
    private WebElement usernameTxt;

    @FindBy(id = "password")
    private WebElement passwordTxt;

    @FindBy(css = signOffID)
    private WebElement passwordHiddenTxt;

    private final String signOffID = "div.show-when-password.hidden";

    @FindBy(id = "login")
    private WebElement logInBtn;

    /**
     * Writes in usernameTxt WebElement the username parameter.
     *
     * @param username is to write in usernameTxt WebElement.
     */
    private void writeInUsername(final String username) {
        WebDriverMethod.setTxtElement(usernameTxt, username);
    }

    /**
     * Writes in passwordTxt WebElement the password parameter.
     *
     * @param password is to write in passwordTxt WebElement.
     */
    private void writeInPassword(final String password) {
        WebDriverMethod.setTxtElement(passwordTxt, password);
    }

    /**
     * Clicks to submit login form.
     */
    private void clickSubmit() {
        logInBtn.click();
    }

    /**
     * Login with username and password parameter from user.
     *
     * @param user use to get user's attribute.
     */
    public void login(final User user) {
        final long time = 5;
        writeInUsername(user.getUsername());
        driver.manage()
                .timeouts()
                .implicitlyWait(time, TimeUnit.SECONDS);
        try {
            driver.findElement(By.cssSelector(signOffID));
            clickSubmit();
            AtlassianPage atlassianPage = new AtlassianPage();
            atlassianPage.login(user);
        } catch (NoSuchElementException e) {
            writeInPassword(user.getPassword());
            clickSubmit();
        } finally {
            driver.manage()
                    .timeouts()
                    .implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        }
    }

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(logInBtn));
    }
}
