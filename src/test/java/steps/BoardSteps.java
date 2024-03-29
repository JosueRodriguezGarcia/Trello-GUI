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

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entities.Context;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;
import trello.ui.pages.board.BoardModalPage;
import trello.ui.pages.board.CopyBoardSection;
import trello.ui.pages.board.MenuBoardPage;
import trello.ui.pages.board.MoreOptionMenu;
import trello.ui.pages.board.TopMenuBoardContent;

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
     *
     * @param context is to share entities.
     */
    public BoardSteps(final Context context) {
        this.context = context;
    }

    /**
     * Creates a new Board instance with a name.
     *
     * @param nameBoard is to name the Board.
     */
    @When("I create a new Board with name {string}")
    public void createNewBoard(final String nameBoard) {
        context.getBoard().setName(nameBoard);
        HomePage homePage = new HomePage();
        homePage.getContentHomePage().openBoardModal();
        BoardModalPage boardModal = new BoardModalPage();
        boardModal.createNewBoard(context.getBoard());
    }

    /**
     * Sees the name of Board in BoardPage.
     */
    @Then("I should see the name of Board in BoardPage")
    public void seeNameOfBoard() {
        BoardPage boardPage = new BoardPage();
        context.getBoard().setId(boardPage.getId());
        Assert.assertEquals(boardPage.getNameBoardButton(), context.getBoard().getName(),
                "The name of this board is not correct");
    }

    /**
     * Sees name Board into parameter name section.
     *
     * @param nameSection is to find the section.
     */
    @Then("I should see the Board in the (.*) section")
    public void seeNameOfBoardInSections(final String nameSection) {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.getContentHomePage().
                existBoardInSection(context.getBoard().getName(), nameSection),
                        "This board not exist in this section");
    }

    /**
     * Copies the board to team with the same title of Board.
     */
    @When("I copy this Board to Team with same title Board")
    public void copyBoardToTeamWithSameTitle() {
        BoardPage boardPage = new BoardPage();
        context.getBoard().setId(boardPage.getId());
        MenuBoardPage menuBoardPage = new MenuBoardPage();
        menuBoardPage.openMoreOption();
        MoreOptionMenu moreOptionMenu = new MoreOptionMenu();
        moreOptionMenu.openCopyBoardSection();
        CopyBoardSection copyBoardSection = new CopyBoardSection();
        copyBoardSection.copyBoard(context.getBoard().getName(), context.getTeam().getName());
    }

    /**
     * Sees the name of owner boards is the name team.
     */
    @Then("I should see that this Board belongs to Team")
    public void seeBoardBelongsToTeam() {
        TopMenuBoardContent topMenuBoardContent = new TopMenuBoardContent();
        Assert.assertEquals(topMenuBoardContent.getNameOwnerBoardButton(), context.getTeam().getName(),
                "This name of Team not exist");
    }
}
