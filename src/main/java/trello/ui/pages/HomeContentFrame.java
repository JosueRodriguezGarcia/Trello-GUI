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

/**
 * HomeContentFrame class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class HomeContentFrame extends BasePage{

    @FindBy(css = "a._1hc34_9rc6xcjf.AqhrxyGOPcyvoq")
    private WebElement boardLink;

    @FindBy(css = "div.board-tile.mod-add")
    private WebElement createBoardLabel;

    /**
     * Wait until web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(boardLink));
    }

    /**
     * Open the Board modal page make a click in the "Create new board" label.
     */
    public void openBoardModal() {
        WebDriverMethod.clickButton(driver, createBoardLabel);
    }
}
