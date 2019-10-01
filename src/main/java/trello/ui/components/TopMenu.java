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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.ui.pages.BasePage;

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
     * Opens the Home page from the TopMenu.
     */
    public void openHomePage() {
        System.out.println("press the link home");
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
     */
    public void logoutPage() {
        openUserActionButton();
        logoutButton.click();
    }

    /**
     * Waits until that element is loaded its text.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        WebDriverMethod.waitForATextInWebElement(wait, "className", USER_CLASS_NAME);
    }

//    @FindBy(name = "house")
//    private WebElement homeLink;
//
//    @FindBy(css = "div[class='TMI28E0KnYSK9p'] span[name='add']")
//    private WebElement addButton;
//
//    @FindBy(className = USER_CLASS_NAME)
//    private WebElement userButton;
//
//    private static final String USER_CLASS_NAME = "_24AWINHReYjNBf";
//
//    /**
//     * Constructor method for create an object of it's class.
//     */
//    public TopMenu() {
//
//    }
//
//    /**
//     * Gets the option home in the TopMenu.
//     *
//     * @return a object of Element.
//     */
//    public Element getHome() {
//        return new Link(homeLink);
//    }
//
//    /**
//     * Gets the option Add in the TopMenu.
//     *
//     * @return a object of Element.
//     */
//    public Element getAdd() {
//        Menu menuAdd = new Menu(addButton);
//        WebElement addBoardButton = driver.findElement(By.
//                cssSelector("button[class='_2jR0BZMM5cBReR'] span[name='board']"));
//        Link createBoard = new Link(addBoardButton);
//        WebElement addTeamButton = driver.findElement(By.
//                cssSelector("button[class='_2jR0BZMM5cBReR'] span[name='organization']"));
//        Link createCreate = new Link(addTeamButton);
//        menuAdd.addElement("addBoard", createBoard);
//        menuAdd.addElement("addTeam", createCreate);
//        return menuAdd;
//    }
//
//    /**
//     * Gets the option User in the TopMenu.
//     *
//     * @return a object of Element.
//     */
//    public Element getUserOption() {
//        Menu menuUser = new Menu(userButton);
//        WebElement logOutButton = driver.findElement(By.
//                cssSelector("button[data-test-id='header-member-menu-logout'] span[class='_1uK2vQ_aMRS2NU']"));
//        Link logOut = new Link(logOutButton);
//        WebElement profileLink = driver.findElement(By.cssSelector("a[href*='profile']"));
//        Link profile = new Link(profileLink);
//        WebElement cardsLink = driver.findElement(By.cssSelector("a[href*='cards']"));
//        Link cards = new Link(cardsLink);
//        WebElement activityLink = driver.findElement(By.cssSelector("a[href*='activity']"));
//        Link activity = new Link(activityLink);
//        menuUser.addElement("logOut", logOut);
//        menuUser.addElement("profile", profile);
//        menuUser.addElement("cards", cards);
//        menuUser.addElement("activity", activity);
//        return menuUser;
//    }
//
//    /**
//     * Waits until that element is loaded its text.
//     */
//    @Override
//    protected void waitUntilPageObjectIsLoaded() {
//        WebDriverMethod.waitForATextInWebElement(wait, "className", USER_CLASS_NAME);
//    }
}
