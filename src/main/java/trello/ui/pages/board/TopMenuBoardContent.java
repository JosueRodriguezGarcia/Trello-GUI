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
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * TopMenuBoardContent class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TopMenuBoardContent extends BasePage {

    @FindBy(className = "js-board-editing-target")
    private WebElement nameBoardButton;

    @FindBy(xpath = "//span[@class='org-label']/..")
    private WebElement nameOwnerBoardButton;

    /**
     * Waits until the web element will clickable.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameBoardButton));
    }

    /**
     * Gets the name of Board into BoardPage.
     *
     * @return as string the name of Board.
     */
    public String getNameBoardButton() {
        return nameBoardButton.getText();
    }

    /**
     * Gets the name of owner into BoardPage.
     *
     * @return as string the name of owner.
     */
    public String getNameOwnerBoardButton() {
        WebDriverMethod.waitUntilFindElement(driver, nameOwnerBoardButton);
        return nameOwnerBoardButton.getText().replace("Free", "");
    }
}
