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

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entities.User;

/**
 * LoginPage class.
 *
 * @author Raul Choque, Josue Rodriguez Garcia
 * @version 0.0.1
 */
public class LoginPage extends BasePage {

    @FindBy(id = "user")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement loginButton;

    /**
     * Writes in usernameField WebElement the username parameter.
     *
     * @param username is to write in usernameField WebElement.
     */
    private void writeInUsername(final String username) {
        WebDriverMethod.setTxtElement(usernameField, username);
    }

    /**
     * Writes in passwordField WebElement the password parameter.
     *
     * @param password is to write in passwordField WebElement.
     */
    private void writeInPassword(final String password) {
        WebDriverMethod.setTxtElement(passwordField, password);
    }

    /**
     * Clicks to submit login form.
     */
    private void clickSubmit() {
        loginButton.click();
    }

    /**
     * Login with username and password parameter from user.
     *
     * @param user use to get user's attribute.
     */
    public void login(final User user) {
        writeInUsername(user.getUsername());
        writeInPassword(user.getPassword());
        clickSubmit();
    }

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
    }
}
