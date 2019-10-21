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

package trello.ui.pages.board;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entities.Board;
import trello.ui.pages.BasePage;

/**
 * BoardModalPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class BoardModalPage extends BasePage {

    @FindBy(className = "background-grid")
    private WebElement backgroundContain;

    @FindBy(className = "subtle-input")
    private WebElement nameBoardField;

    @FindBy(css = "button.button.primary")
    private WebElement createBoardButton;

    /**
     * Waits until a web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(backgroundContain));
    }

    /**
     * Creates new Board from a instance of Board class.
     *
     * @param board is to get required data.
     */
    public void createNewBoard(final Board board) {
        WebDriverMethod.setTxtElement(nameBoardField, board.getName());
        WebDriverMethod.clickButton(driver, createBoardButton);
    }
}
