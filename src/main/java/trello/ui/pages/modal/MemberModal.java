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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

import java.util.List;

/**
 * MemberModal class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class MemberModal extends BasePage {

    @FindBy(className = "pop-over-header-close-btn")
    private WebElement closeWindowButton;

    @FindBy(className = "js-search-mem")
    private WebElement searchMemberField;

    @FindBy(className = "js-show-org-members")
    private WebElement showMemberButton;

    @FindBy(className = "js-select-member")
    private List<WebElement> memberButton;

    /**
     * Does click in close modal button.
     *
     * @return a instance cardModal.
     */
    public CardModal clickCloseWindowButton() {
        closeWindowButton.click();
        return new CardModal();
    }

    /**
     * Shows all members in the list.
     */
    public void clickShowMemberButton() {
        showMemberButton.click();
    }

    /**
     * Does click in a member to be assign.
     *
     * @param member defines that member is select.
     */
    public void clickMemberButton(final String member) {
        for (int index = 0; index < memberButton.size(); index++) {
            if (memberButton.get(index).getText().contains(member)) {
                memberButton.get(index).click();
            }
        }
    }

    /**
     * Adds a member to card.
     *
     * @param members defines a input list with the members to be assign.
     */
    public void addMember(final List<String> members) {
        for (int index = 0; index < members.size(); index++) {
            clickMemberButton(members.get(index));
        }
    }

    /**
     * Waits that Show Member button is visibility.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(showMemberButton));
    }
}
