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

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
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
        context.getBoard().setName(boardTitle);
    }

    /**
     * Creates a list with the given title.
     *
     * @param listTitle is the title to be given to the list.
     */
    @When("I create a new list with {string} as title")
    public void createNewList(final String listTitle) {
        boardPage = new BoardPage();
        List list = new List();
        list.setTitle(listTitle);
        context.getLists().put("list", list);
        boardPage.createNewList(listTitle);
    }

    /**
     * Verifies if the context's list is on the board.
     */
    @Then("I should see the new created list with the given title")
    public void verifyListCreation() {
        boardPage = new BoardPage();
        Assert.assertTrue(boardPage.isThereThisListByTitle(context.getLists().get("list").getTitle()));
    }

    /**
     * Moves all cards in given list to given target list.
     *
     * @param listSource is the list which cards are wanted to move from.
     * @param listTarget is the list which the cards are wanted to move to. This list must be empty.
     */
    @When("I move all cards in (.*) to (.*)")
    public void moveAllCardsInList(final String listSource, final String listTarget) {
        boardPage.moveAllCards(listSource, listTarget);
    }

    /**
     * Verifies if the cards that were on source list are now in the target list.
     */
    @Then("all cards that were on source list should appear on target list")
    public void verifyCardsOnTargetList() {
        boardPage = new BoardPage();
        Assert.assertTrue(context.getLists().get("SourceList")
                        .areListsEquals(boardPage.getCardsInList(context.getLists().get("TargetList").getTitle())),
                "Cards were not correctly moved.");
    }

    /**
     * Sorts cards in list by card name.
     *
     * @param listTitle is title of the list which cards are wanted to be sorted by name.
     */
    @When("I sort cards in (.*) list by card name")
    public void sortCardsInListByCardName(final String listTitle) {
        boardPage = new BoardPage();
        List list = new List();
        list.setTitle(listTitle);
        list.setCards(boardPage.getCardsInList(listTitle));
        context.getLists().put(listTitle, list);
        boardPage.sortCardsInListByName(listTitle);
    }

    /**
     * Verifies is source list is empty after moving all cards from it.
     */
    @Then("the source list should be empty")
    public void verifySourceList() {
        boardPage = new BoardPage();
        Assert.assertEquals(boardPage.getQttyCardsInList(context.getLists().get("SourceList").getTitle()), 0,
                "Cards were not correctly moved. Cards are still in source list.");
    }

    /**
     * Verifies if cards in list are sorted by name correctly.
     */
    @Then("all cards should be displayed correctly sorted")
    public void verifyCardsSortedByName() {
        boardPage = new BoardPage();
        Assert.assertTrue(context.getLists().get("SourceList")
                        .isSortedByName(boardPage.getCardsInList(context.getLists().get("SourceList").getTitle())),
                "Cards were not correctly sorted.");
    }

    /**
     * Copies a card to other list.
     *
     * @param card      is the title of the card which is wanted to copy.
     * @param listTitle is the title of the list which is wanted to copy the card to.
     */
    @Then("I copy (.*) card to (.*) list")
    public void copyCardToList(final String card, final String listTitle) {
        boardPage = new BoardPage();
        context.getCard().setTitle(card);
        List targetList = new List();
        targetList.setTitle(listTitle);
        targetList.setCards(boardPage.getCardsInList(listTitle));
        context.getLists().put("targetList", targetList);
        List sourceList = new List();
        String sourceListTitle = boardPage.getListWhereCardIs(card);
        sourceList.setTitle(sourceListTitle);
        context.getLists().put("sourceList", sourceList);
        boardPage.copyCardToList(card, sourceListTitle, listTitle);
    }

    /**
     * Verifies if the copied card appears on source and target list.
     */
    @Then("the card appears correctly on source and target list")
    public void verifyCardAppearsOnSourceAndTargetList() {
        boardPage = new BoardPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(boardPage.isCardInList(context.getCard().getTitle(), context.getLists()
                .get("targetList").getTitle()));
        softAssert.assertTrue(boardPage.isCardInList(context.getCard().getTitle(), context.getLists()
                .get("sourceList").getTitle()));
        softAssert.assertAll();
    }

    /**
     * Saves the list data in the context.
     *
     * @param lists is the list of lists to be saved in the context.
     */
    @Given("there are following lists in the board")
    public void thereAreFollowingListsInTheBoard(final java.util.List<String> lists) {
        boardPage = new BoardPage();
        for (int index = 0; index < lists.size(); index++) {
            List list = new List();
            list.setTitle(lists.get(index));
            list.setCards(boardPage.getCardsInList(lists.get(index)));
            context.getLists().put(lists.get(index), list);
        }
    }
}
