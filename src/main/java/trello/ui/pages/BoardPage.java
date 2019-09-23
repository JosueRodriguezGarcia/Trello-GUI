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

/**
 * BoardPage class.
 *
 * @author Raul Choque
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

    @FindBy(css = ".list-header-extras-menu")
    private WebElement listMenuBtn;

    @FindBy(css = ".js-close-list")
    private WebElement archiveListBtn;

    @FindBy(css = ".dark-hover")
    private WebElement btn;


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
    public String getListTitle() {
        return newListHeader.getText();
    }

    /**
     * Gets new list name.
     */
    public void removeList() {
        listMenuBtn.click();
        archiveListBtn.click();
        btn.click();
    }

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
