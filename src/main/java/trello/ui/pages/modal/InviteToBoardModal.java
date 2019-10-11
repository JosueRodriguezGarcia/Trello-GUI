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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;
import trello.ui.pages.BoardPage;

import java.util.List;

/**
 * InviteToBoardModal class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class InviteToBoardModal extends BasePage {

    @FindBy(className = "autocomplete-input")
    private WebElement emailOrUserField;

    @FindBy(css = "button.autocomplete-btn.primary")
    private WebElement sendInvitationButton;

    /**
     * Sets email Field.
     *
     * @param members defines a input list.
     */
    public void fillEmailOrUserField(final List<String> members) {
        for (int index = 0; index < members.size(); index++) {
            WebDriverMethod.setTxtElement(emailOrUserField, members.get(index));
            emailOrUserField.sendKeys(Keys.SPACE);
        }
        clickSendInvitationButton();
    }

    /**
     * Does click in invitation button.
     *
     * @return a BoardPage.
     */
    public BoardPage clickSendInvitationButton() {
        sendInvitationButton.click();
        return new BoardPage();
    }

    /**
     * Waits that the button send invite is visibility.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(emailOrUserField));
    }
}
