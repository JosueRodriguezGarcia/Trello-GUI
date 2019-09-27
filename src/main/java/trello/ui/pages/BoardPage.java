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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * BoardPage class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public class BoardPage extends BasePage {

    @FindBy(css = ".placeholder")
    private WebElement newListButton;

    @FindBy(name = "name")
    private WebElement newListNameField;

    @FindBy(css = ".primary")
    private WebElement addNewListButton;

    @FindBy(css = "a[class='js-close-list']")
    private WebElement archiveListButton;

    private static final String BOARD_TITLE_XPATH = "//h2[contains(text(), \"%s\")]";
    private static final String BOARD_MENU_SUFFIX = "/following-sibling::div";

    /**
     * Creates a new list.
     *
     * @param listTitle is the list name that will be assigned to the list.
     */
    public void createNewList(final String listTitle) {
        newListButton.click();
        WebDriverMethod.setTxtElement(newListNameField, listTitle);
        addNewListButton.click();
    }

    /**
     * Verifies is the list is on the board.
     *
     * @param listTitle is the title of the list that is requested to find.
     * @return true is the list is on the board.
     */
    public boolean isThereThisListByTitle(final String listTitle) {
        String boardTitleXpath = String.format(BOARD_TITLE_XPATH, listTitle);
        WebElement listHeader = driver.findElement(By.xpath(boardTitleXpath));
        return listHeader.getAttribute("textContent").equals(listTitle);
    }

    /**
     * Archives list by list title.
     * @param listTitle is the title of the list that is requested to archive.
     */
    public void archiveListByTitle(final String listTitle) {
        String boardMenuXpath = String.format(BOARD_TITLE_XPATH + BOARD_MENU_SUFFIX, listTitle);
        WebElement listMenuBtn = driver.findElement(By.xpath(boardMenuXpath));
        listMenuBtn.click();
        archiveListButton.click();
    }

    /**
     * Wait until Page object is found.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
