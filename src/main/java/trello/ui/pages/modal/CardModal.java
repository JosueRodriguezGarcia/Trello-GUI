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
import trello.ui.pages.BoardPage;

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

    @FindBy(className = "js-add-due-date")
    private WebElement dueDateButton;

    @FindBy(className = "js-details-edit-due-date")
    private WebElement dateButton;

    @FindBy(className = "js-change-card-members")
    private WebElement memberButton;

    @FindBy(className = "js-card-detail-members-list")
    private WebElement cardMembersList;

    private List<WebElement> cardMemberItem;

    /**
     * Does click the "add checklist button".
     *
     * @return a instance of CheckListModal class.
     */
    public CheckListModal clickCheckListButton() {
        checkListButton.click();
        return new CheckListModal();
    }

    /**
     * Does click the "Due Date" button.
     *
     * @return a instance of DueDataModal class.
     */
    public DueDataModal clickDueDateButton() {
        dueDateButton.click();
        return new DueDataModal();
    }

    /**
     * Does click in the member button.
     *
     * @return a instance of memberModal.
     */
    public MemberModal clickMemberButton() {
       memberButton.click();
       return new MemberModal();
    }
    /**
     * Does click the "close button".
     *
     * @return a instance of BoardPage class.
     */
    public BoardPage clickCloseWindowsButton() {
        closeWindowsButton.click();
        return new BoardPage();
    }

    /**
     * Does click the date button.
     *
     * @return a instance of DueDataModal class.
     */
    public DueDataModal clickDateButton() {
        dateButton.click();
        return new DueDataModal();
    }

    /**
     * Gets the list of member that exist.
     */
    private void getCardMembersList() {
        cardMemberItem = cardMembersList.findElements(By.className("js-member-on-card-menu"));
    }

    /**
     * Gets a member of a list.
     *
     * @param index defines the position of the list
     * @return a string with the initials of a member in a card.
     */
    public String getMember(final int index) {
        getCardMembersList();
        return cardMemberItem.get(index).getText();
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
     * Waits that card title is visibility.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(dueDateButton));
    }
}
