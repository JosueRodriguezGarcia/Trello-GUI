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

import static org.openqa.selenium.By.cssSelector;

/**
 * TopMenu class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TopMenu extends BasePage {

    @FindBy(name = "house")
    private WebElement homeLink;

    @FindBy(css = "div[class='TMI28E0KnYSK9p'] span[name='add']")
    private WebElement addButton;

    @FindBy(className = USER_CLASS_NAME)
    private WebElement userButton;

    private static final String USER_CLASS_NAME = "_24AWINHReYjNBf";

    /**
     * Constructor method for create an object of it's class.
     */
    public TopMenu() {

    }

    /**
     * Gets the option home in the TopMenu.
     *
     * @return a object of IElement.
     */
    public IElement getHome() {
        return new Link(homeLink);
    }

    /**
     * Gets the option Add in the TopMenu.
     *
     * @return a object of IElement.
     */
    public IElement getAdd() {
        Menu menuAdd = new Menu(addButton);
        By boardByCss = cssSelector("button[class='_2jR0BZMM5cBReR'] span[name='board']");
        WebElement addBoardButton = driver.findElement(boardByCss);
        Link createBoard = new Link(addBoardButton);
        By teamByCss = cssSelector("button[class='_2jR0BZMM5cBReR'] span[name='organization']");
        WebElement addTeamButton = driver.findElement(teamByCss);
        Link createCreate = new Link(addTeamButton);
        menuAdd.addElement("addBoard", createBoard);
        menuAdd.addElement("addTeam", createCreate);
        return menuAdd;
    }

    /**
     * Gets the option User in the TopMenu.
     *
     * @return a object of IElement.
     */
    public IElement getUserOption() {
        String linkCss = "div[data-test-id='header-member-menu-popover'] a[href*='%s']";
        Menu menuUser = new Menu(userButton);
        By logOutByCss = cssSelector("button[data-test-id='header-member-menu-logout'] span[class='_1uK2vQ_aMRS2NU']");
        WebElement logOutButton = driver.findElement(logOutByCss);
        Link logOut = new Link(logOutButton);
        By profileByCss = cssSelector(String.format(linkCss, "profile"));
        WebElement profileLink = driver.findElement(profileByCss);
        Link profile = new Link(profileLink);
        By cardsByCss = cssSelector(String.format(linkCss, "cards"));
        WebElement cardsLink = driver.findElement(cardsByCss);
        Link cards = new Link(cardsLink);
        By activityByCss = cssSelector(String.format(linkCss, "activity"));
        WebElement activityLink = driver.findElement(activityByCss);
        Link activity = new Link(activityLink);
        menuUser.addElement("logOut", logOut);
        menuUser.addElement("profile", profile);
        menuUser.addElement("cards", cards);
        menuUser.addElement("activity", activity);
        return menuUser;
    }

    /**
     * Waits until that element is loaded its text.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        WebDriverMethod.waitForATextInWebElement(wait, "className", USER_CLASS_NAME);
    }
}
