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

package trello.ui.pages.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

import java.util.List;

/**
 * CardModal class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class CardModal extends BasePage {

    @FindBy(className = "js-card-detail-title-input")
    private WebElement cardTitle;

    @FindBy(className = "js-close-window")
    private WebElement closeWindowsButton;

    @FindBy(className = "js-add-checklist-menu")
    private WebElement checkListButton;

    @FindBy(className = "checklist-title")
    private List<WebElement> checkLists;

    private static final String CARD_TITLE = "hide-on-edit";
    /**
     * Does click the "add checklist button".
     */
    public void clickCheckListButton() {
        checkListButton.click();
    }

    /**
     * Does click the "close button".
     */
    public void clickCloseWindowsButton() {
        closeWindowsButton.click();
    }

    /**
     * Searches a checklist in card.
     *
     * @param checkListTitle defines the checklist title that search.
     * @return a boolean with true if exists.
     */
    public boolean searchCheckList(final String checkListTitle) {
        boolean result = false;
        for (WebElement checkList : checkLists) {
            if (checkList.findElement(By.className(CARD_TITLE)).getText().equals(checkListTitle)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Wait that card title is visibility.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(cardTitle));
    }
}
