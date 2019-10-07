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

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.ui.pages.BasePage;
import trello.ui.pages.LoggedOutPage;

/**
 * TopMenu class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TopMenu extends BasePage {

    @FindBy(name = "house")
    private WebElement homeLink;

    @FindBy(name = "add")
    private WebElement addButton;

    @FindBy(css = "button[class='_2jR0BZMM5cBReR'] span[name='board']")
    private WebElement createBoardButton;

    @FindBy(css = "button[class='_2jR0BZMM5cBReR'] span[name='organization']")
    private WebElement createTeamButton;

    @FindBy(className = USER_CLASS_NAME)
    private WebElement userActionButton;

    private static final String USER_CLASS_NAME = "_24AWINHReYjNBf";

    @FindBy(css = "div[data-test-id='header-member-menu-popover'] a[href*='profile']")
    private WebElement settingUserLink;

    @FindBy(css = "div[data-test-id='header-member-menu-popover'] a[href*='activity']")
    private WebElement activityUsersLink;

    @FindBy(css = "div[data-test-id='header-member-menu-popover'] a[href*='cards']")
    private WebElement userCardsLink;

    @FindBy(css = "button[data-test-id='header-member-menu-logout'] span[class='_1uK2vQ_aMRS2NU']")
    private WebElement logoutButton;

    /**
     * Waits until that element is loaded its text.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        WebDriverMethod.waitForATextInWebElement(wait, "className", USER_CLASS_NAME);
    }

    /**
     * Opens the Home page from the TopMenu.
     */
    public void openHomePage() {
        homeLink.click();
    }

    /**
     * Open the menu from addButton.
     */
    private void openAddButton() {
        addButton.click();
    }

    /**
     * Opens the create Board.
     */
    public void createBoard() {
        openAddButton();
        createBoardButton.click();
    }

    /**
     * Opens the create Team.
     */
    public void createTeam() {
        openAddButton();
        createTeamButton.click();
    }

    /**
     * Opens the menu from userActionButton.
     */
    private void openUserActionButton() {
        userActionButton.click();
    }

    /**
     * Opens the etting user page.
     */
    public void openSettingUserPage() {
        openUserActionButton();
        settingUserLink.click();
    }

    /**
     * Opens the activity users page.
     */
    public void openActivityUserPage() {
        openUserActionButton();
        activityUsersLink.click();
    }

    /**
     * Opens the user cards page.
     */
    public void openUserCardsPage() {
        openUserActionButton();
        userCardsLink.click();
    }

    /**
     * Logout from the page.
     *
     * @return a LoggedOutPage.
     */
    public LoggedOutPage logoutPage() {
        openUserActionButton();
        logoutButton.click();
        return new LoggedOutPage();
    }

    /**
     * Gets the initial full name of HomePage class.
     *
     * @return as string the initial of full name.
     */
    public String getFullNameInitials() {
        WebDriverMethod.waitElementBeClickable(driver, userActionButton);
        return userActionButton.getText();
    }

    /**
     * Gets the Driver of this Page object.
     *
     * @return a WebDriver object.
     */
    public WebDriver getDriver() {
        return driver;
    }
}
