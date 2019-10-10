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

package trello.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entities.Board;
import trello.entities.Card;
import trello.entities.Context;
import trello.ui.PageTransporter;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;
import trello.ui.pages.modal.CardModal;
import trello.ui.pages.modal.CheckListModal;

import java.util.Map;
import java.util.Set;

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
    private Context context;

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
        context.getLists().get("list").setTitle(listTitle);
        context.getCard().setTitle(cardTitle);
        boardPage.addCardInList(listTitle, cardTitle);
    }

    /**
     * Verifies if a card is add to a list.
     */
    @Then("I should see the new card with the given task")
    public void verifyNewCardIsDisplayedInList() {
        boolean result = boardPage.searchCardInList(context.getLists().get("list").getTitle(), context.getCard()
                .getTitle());
        Assert.assertTrue(result);
    }

    /**
     * Verifies if a card title is the correct.
     */
    @Then("I verify that the name is the correct")
    public void verifyTheNameCard() {
        String actualTitle = boardPage.getCardTitle(context.getLists().get("list").getTitle(), context.getCard()
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
        boardPage.selectCard(cardTitle);
    }

    /**
     * Adds a checklist to card.
     *
     * @param checkListTitle defines the checklist title to be created.
     */
    @And("I add a checklist with (.*) title")
    public void addChecklist(final String checkListTitle) {
        cardModal = new CardModal();
        cardModal.clickCheckListButton();
        checkListModal = new CheckListModal();
        checkListModal.addCheckList(checkListTitle);
        cardModal.clickCloseWindowsButton();
    }

    /**
     * Verifies that the checklist in a card is displayed.
     */
    @Then("the checklist section is displayed on the card details")
    public void theChecklistSectionIsDisplayedOnTheCardDetails() {
        boardPage.selectCard(context.getCard().getTitle());
        cardModal = new CardModal();
        boolean result = cardModal.searchCheckList("TestCheckList");
        Assert.assertTrue(result);
    }

    /**
     * Goes to the Board page using the PageTransporter.
     */
    @When("I go to the Board")
    public void goToBoard() {
        HomePage homePage = new HomePage();
//        PageTransporter.navigateToURL(context.getBoardToCard().getUrl());
        PageTransporter.navigateToURL("https://trello.com/b/HxVABm4Z/board-to-card");
    }

    /**
     * Create a new Card with cardDate parameter.
     *
     * @param cardData is to create a Card.
     */
    @When("I create a new Card with data:")
    public void createNewCard(final Map<String, String> cardData) {
        Card card = new Card();
        card.addDataToCard(cardData);
        context.setCard(card);
        BoardPage boardPage = new BoardPage();
        Set<String> keysCard = cardData.keySet();
        boardPage.addCardInList(context.getListToCard().getTitle(),
                card, keysCard);
    }

    /**
     * Sees the data of Card that was created.
     */
    @Then("I should see the data of new Card")
    public void seeDataOfNewCard() {
        BoardPage boardPage = new BoardPage();
//        boardPage
    }

}
