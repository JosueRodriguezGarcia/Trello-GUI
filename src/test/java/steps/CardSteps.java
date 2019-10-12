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

package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.testng.Assert;

import trello.entities.Context;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;
import trello.ui.pages.modal.CardModal;
import trello.ui.pages.modal.CheckListModal;
import trello.ui.pages.modal.DueDataModal;
import trello.ui.pages.modal.InviteToBoardModal;
import trello.ui.pages.modal.MemberModal;

import java.util.List;
import java.util.Map;

/**
 * CardSteps class.
 *
 * @author Josue Rodrguiguez.
 * @version 0.0.1
 */
public class CardSteps {

    private HomePage homePage;
    private BoardPage boardPage;
    private CardModal cardModal;
    private CheckListModal checkListModal;
    private DueDataModal dueDataModal;
    private Context context;
    private MemberModal memberModal;
    private InviteToBoardModal inviteToBoardModal;

    /**
     * Constructor method initializes the attributes.
     *
     * @param currentContext defines a context fot by set.
     */
    public CardSteps(final Context currentContext) {
        this.context = currentContext;
    }

    /**
     * Adds a new card to a list.
     *
     * @param listTitle defines the title of list.
     * @param cardTitle defines the title od card.
     */
    @And("I add a card to (.*) list with (.*) as task")
    public void addCardToList(final String listTitle, final String cardTitle) {
        boardPage = new BoardPage();
        context.getList().setTitle(listTitle);
        context.getCard().setTitle(cardTitle);
        boardPage.addCardInList(listTitle, cardTitle);
    }

    /**
     * Verifies if a card is add to a list.
     */
    @Then("I should see the new card with the given task")
    public void verifyNewCardIsDisplayedInList() {
        boolean result = boardPage.searchCardInList(context.getList().getTitle(), context.getCard()
                .getTitle());
        Assert.assertTrue(result);
    }

    /**
     * Verifies if a card title is the correct.
     */
    @Then("I verify that the name is the correct")
    public void verifyTheNameCard() {
        String actualTitle = boardPage.getCardTitle(context.getList().getTitle(), context.getCard()
                .getTitle());
        Assert.assertEquals(context.getCard().getTitle(), actualTitle);
    }

    /**
     * Selects a card of board.
     *
     * @param cardTitle defines the card title that want selected.
     */
    @And("I select (.*) card")
    public void selectCard(final String cardTitle) {
        boardPage = new BoardPage();
        context.getCard().setTitle(cardTitle);
        cardModal = boardPage.selectedCard(cardTitle);
    }

    /**
     * Adds a checklist to card.
     *
     * @param checkListTitle defines the checklist title to be created.
     */
    @And("I add a checklist with (.*) title")
    public void addChecklist(final String checkListTitle) {
        cardModal.clickCheckListButton();
        checkListModal = new CheckListModal();
        cardModal = checkListModal.addCheckList(checkListTitle);
    }

    /**
     * Verifies that the checklist in a card is displayed.
     */
    @Then("the checklist section is displayed on the card details")
    public void theChecklistSectionIsDisplayedOnTheCardDetails() {
        boolean result = cardModal.searchCheckList("TestCheckList");
        Assert.assertTrue(result);
    }

    /**
     * Assigns a due data.
     *
     * @param dataTable defines a input data table.
     */
    @And("I assign a due date")
    public void assignADueDate(final Map<String, String> dataTable) {
        dueDataModal = cardModal.clickDueDateButton();
        dueDataModal.setInformation(dataTable);
        context.getDueDate().setInformation(dataTable);
        cardModal = dueDataModal.clickSaveButton();
    }

    /**
     * Verifies that the due date in a card is displayed in details.
     */
    @Then("The due date section is displayed on the card details")
    public void theDueDateSectionIsDisplayedOnTheCardDetails() {
        dueDataModal = cardModal.clickDateButton();
        Assert.assertEquals(dueDataModal.getDate(), context.getDueDate().getDate());
        Assert.assertEquals(dueDataModal.getTime(), context.getDueDate().getTime());
    }

    /**
     * Adds members to card.
     *
     * @param members defines a input list with the member to be add.
     */
    @And("I add a member")
    public void addAMember(final List<String> members) {
        memberModal = cardModal.clickMemberButton();
        memberModal.addMember(members);
        context.getCard().setMembers(members);
        cardModal = memberModal.clickCloseWindowButton();
    }

    /**
     * Verifies that the member is shown in the card.
     */
    @Then("the member's initials are shown in the card")
    public void theMemberSInitialsAreShownInTheCard() {
        for (int index = 0; index < context.getCard().getMembers().size(); index++) {
            Assert.assertEquals(cardModal.getMember(index), context.getCard().getMembers().get(index).getInitials());
        }
    }

    /**
     * Adds members to card.
     *
     * @param members defines a input list.
     */
    @And("I add members to board")
    public void addMembersToBoard(final List<String> members) {
        boardPage = new BoardPage();
        inviteToBoardModal = boardPage.clickInviteButton();
        inviteToBoardModal.fillEmailOrUserField(members);
    }
}
