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
import org.testng.Assert;
import trello.entities.Context;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;

/**
 * CardSteps class.
 *
 * @author Josue Rodrguiguez.
 * @version 0.0.1
 */
public class CardSteps {
    private HomePage homePage;
    private BoardPage boardPage;
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
    public void iAddACardToTestListListWithAsTask(final String listTitle, final String cardTitle) {
        boardPage = new BoardPage();
        context.getList().setTitle(listTitle);
        context.getCard().setTitle(cardTitle);
        boardPage.addCardInList(listTitle, cardTitle);
    }

    /**
     * Verifies if a card is add to a list.
     */
    @Then("I should see the new card with the given task")
    public void iShouldSeeTheNewCardWithTheGivenTask() {
        boolean result = boardPage.searchCardInList(context.getList().getTitle(), context.getCard().getTitle());
        Assert.assertTrue(result);
    }
}
