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

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * CheckListModal class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class CheckListModal extends BasePage {

    @FindBy(className = "js-checklist-title")
    private WebElement checkListTitleField;

    @FindBy(className = "js-add-checklist")
    private WebElement confirmAddCheckListButton;

    /**
     * Does click the "add button" for confirm.
     */
    public void clickConfirmAddCheckListButton() {
        confirmAddCheckListButton.click();
    }

    /**
     * Add a checklist to card.
     *
     * @param checkListTitle defines the title od the new checklist.
     */
    public void addCheckList(final String checkListTitle) {
        WebDriverMethod.setTxtElement(checkListTitleField, checkListTitle);
        clickConfirmAddCheckListButton();
    }

    /**
     * Wait that add button to be clickable.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmAddCheckListButton));
    }
}
