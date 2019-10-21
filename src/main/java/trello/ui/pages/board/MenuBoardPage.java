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

package trello.ui.pages.board;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * MenuBoardPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class MenuBoardPage extends BasePage {

    @FindBy(css = ".board-menu-header-title.js-board-menu-title-text")
    private WebElement titlePageLabel;

    @FindBy(css = ".board-menu-navigation-item-link.js-open-more")
    private WebElement optionMoreLink;

    /**
     * Waits until web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titlePageLabel));
    }

    /**
     * Opens the more option link.
     */
    public void openMoreOption() {
        WebDriverMethod.clickButton(driver, optionMoreLink);
    }

}
