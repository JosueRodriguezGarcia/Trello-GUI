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
    private WebElement newListBtn;

    @FindBy(name = "name")
    private WebElement newListNameTxtBox;

    @FindBy(css = ".primary")
    private WebElement addNewListBtn;

    @FindBy(css = ".list-header-name")
    private WebElement newListHeader;

    @FindBy(css = "a[class='js-close-list']")
    private WebElement archiveListBtn;

    private String BOARD_TITLE_XPATH = "//h2[contains(text(), \"%s\")]";
    private String BOARD_MENU_SUFFIX = "/following-sibling::div";

    /**
     * Creates a new list.
     *
     * @param listTitle is the list name that will be assigned to the list.
     */
    public void createNewList(final String listTitle) {
        newListBtn.click();
        WebDriverMethod.setTxtElement(newListNameTxtBox, listTitle);
        addNewListBtn.click();
    }

    /**
     * Gets new list name.
     *
     * @return the name of the list.
     */
    public boolean isThereThisList(final String listTitle) {
        String boardTitleXpath = String.format(BOARD_TITLE_XPATH, listTitle);
        WebElement listHeader = driver.findElement(By.xpath(boardTitleXpath));
        return listHeader.getAttribute("textContent").equals(listTitle);
    }

    /**
     * Gets new list name.
     */
    public void removeList(final String listTitle) {
        String boardMenuXpath = String.format(BOARD_TITLE_XPATH + BOARD_MENU_SUFFIX, listTitle);
        WebElement listMenuBtn = driver.findElement(By.xpath(boardMenuXpath));
        listMenuBtn.click();
        archiveListBtn.click();
    }

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
