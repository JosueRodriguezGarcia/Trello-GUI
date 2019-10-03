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
import trello.entities.Context;
import trello.entities.List;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;

/**
 * ListSteps class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public class ListSteps {

    private HomePage homePage;
    private BoardPage boardPage;
    private Context context;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public ListSteps(final Context currentContext) {
        this.context = currentContext;
    }

    /**
     * Selects the board to go.
     *
     * @param boardTitle is the title of the board.
     */
    @When("I select (.*) board")
    public void selectABoard(final String boardTitle) {
        homePage = new HomePage();
        homePage.clickOnABoard(boardTitle);
    }

    /**
     * Creates a list with the given title.
     *
     * @param listTitle is the title to be given to the list.
     */
    @And("I create a new list with {string} as title")
    public void createNewList(final String listTitle) {
        boardPage = new BoardPage();
        context.getListSource().setTitle(listTitle);
        boardPage.createNewList(listTitle);
    }

    /**
     * Verifies if the context's list is on the board.
     */
    @Then("I should see the new created list with the given title")
    public void verifyList() {
        boardPage = new BoardPage();
        Assert.assertTrue(boardPage.isThereThisListByTitle(context.getListSource().getTitle()));
    }

    @And("I move all cards in (.*) to (.*)")
    public void moveAllCardsInList(final String listSource, final String listTarget) {
        boardPage = new BoardPage();
        context.getListSource().setTitle(listSource);
        context.getListSource().setCards(boardPage.getCardsInList(listSource));
        context.getListTarget().setTitle(listTarget);
        boardPage.moveAllCards(listSource, listTarget);
    }

    @Then("all cards that were on source list should appear on target list")
    public void verifyCardsOnTargetList() {
        boardPage = new BoardPage();
        Assert.assertTrue(context.getListSource()
                        .areListsEquals(boardPage.getCardsInList(context.getListTarget().getTitle())),
                "Cards were not correctly moved");
    }

    @And("I sort cards in (.*) list by card name")
    public void sortCardsInListByCardName(final String listTitle) {
        boardPage = new BoardPage();
        context.getList().setTitle(listTitle);
        context.getList().setCards(boardPage.getCardsInList(listTitle));
        boardPage.sortCardsInListByName(listTitle);
    }

    @And("the source list should be empty")
    public void verifySourceList() {
        boardPage = new BoardPage();
        Assert.assertEquals(boardPage.getCardsInList(context.getListSource().getTitle()).size(), 0,
                "Cards were not correctly moved");
    }

    @Then("all cards should be displayed correctly sorted")
    public void verifyCardsSortedByName() {
        boardPage = new BoardPage();
        Assert.assertTrue(context.getList().verifySortByName(boardPage.getCardsInList(context.getList().getTitle()))
                , "Cards were not correctly sorted");
    }
}
