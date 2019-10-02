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
        context.getList().setTitle(listTitle);
        boardPage.createNewList(listTitle);
    }

    /**
     * Verifies if the context's list is on the board.
     */
    @Then("I should see the new created list with the given title")
    public void verifyList() {
        boardPage = new BoardPage();
        Assert.assertTrue(boardPage.isThereThisListByTitle(context.getList().getTitle()));
    }

    @And("I move all cards in (.*) to (.*)")
    public void moveAllCardsInList(final String listFrom, final String listTarget) {
        boardPage = new BoardPage();
        boardPage.moveAllCards(listFrom, listTarget);
    }

    @Then("all cards that where on source list should appear on target list")
    public void allCardsThatWhereOnSourceListShouldAppearOnTargetList() {

    }
}
