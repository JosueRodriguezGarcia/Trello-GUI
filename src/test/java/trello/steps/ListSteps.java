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

    public ListSteps(Context context) {
        this.context = context;
    }

    @When("I select a board")
    public void selectABoard() {
        homePage = new HomePage();
        homePage.clickOnABoard();
    }

    @And("I create a new list with (.*) title")
    public void createNewList(final String listTitle) {
        boardPage = new BoardPage();
        context.getList().setTitle(listTitle);
        boardPage.createNewList(listTitle);
    }

    @Then("I should see the new created list with the given title")
    public void verifyListTitle() {
        Assert.assertEquals(context.getList().getTitle(), boardPage.getListTitle());
    }
}
