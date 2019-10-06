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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entities.Board;
import trello.entities.Context;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;
import trello.ui.pages.board.BoardModalPage;

/**
 * BoardSteps class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class BoardSteps {

    private Context context;

    /**
     * Constructor method for share the context attribute apply DI.
     * @param context
     */
    public BoardSteps(Context context) {
        this.context = context;
    }

    /**
     * Creates a new Board instance with a name.
     *
     * @param nameBoard is to name the Board.
     */
    @When("I create a new Board with name {string}")
    public void createNewBoard(String nameBoard) {
        context.getBoard().setName(nameBoard);
        HomePage homePage = new HomePage();
        homePage.getContentHomePage().openBoardModal();
        BoardModalPage boardModal = new BoardModalPage();
        boardModal.createNewBoard(context.getBoard());
    }

    @Then("I should see the name of Board in BoardPage")
    public void seeNameOfBoard() {
        BoardPage boardPage = new BoardPage();
        context.getBoard().setId(boardPage.getId());
        Assert.assertEquals(boardPage.getNameBoardButton(), context.getBoard().getName(),
                "The name of this board is not correct");
        System.out.println("###################" + "I should see the name of Board in BoardPage");
    }

    @Then("I should see the Board in the {string} and {string} sections")
    public void i_should_see_the_Board_in_the_and_sections(String string, String string2) {

    }
}