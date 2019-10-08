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
import trello.entities.Context;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomeContentFrame;
import trello.ui.pages.HomePage;
import trello.ui.pages.board.*;

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
        HomeContentFrame homeContentFrame = new HomeContentFrame();
        homeContentFrame.openBoardModal();
        BoardModalPage boardModal = new BoardModalPage();
        boardModal.createNewBoard(context.getBoard());
    }

    /**
     * Sees the name of Board in BoardPage.
     */
    @Then("I should see the name of Board in BoardPage")
    public void seeNameOfBoard() {
        BoardPage boardPage = new BoardPage();
        TopMenuBoardContent topMenuBoardContent = new TopMenuBoardContent();
        context.getBoard().setId(boardPage.getId());
        Assert.assertEquals(topMenuBoardContent.getNameBoardButton(), context.getBoard().getName(),
                "The name of this board is not correct");
    }

    /**
     * Sees name Board into parameter name section.
     *
     * @param nameSection is to find the section.
     */
    @Then("I should see the Board in the (.*) section")
    public void seeNameOfBoardInSections(final String nameSection) {
//        HomePage homePage = new HomePage();
        HomeContentFrame homeContentFrame = new HomeContentFrame();
        Assert.assertTrue(homeContentFrame.
                existBoardInSection(context.getBoard().getName(), nameSection),
                        "This board not exist in this section");
    }

    /**
     * Opens Board thar was created previously.
     *
     * @param nameSection is to find the board to open it.
     */
    @When("I open the Board from (.*) section")
    public void openBoard(final String nameSection) {
//        HomePage homePage = new HomePage();
        HomeContentFrame homeContentFrame = new HomeContentFrame();
        homeContentFrame.openBoard(context.getBoard().getName(), nameSection);
    }

    /**
     * Copy the board to team with the same title of Board.
     */
    @When("I copy this Board to Team with same title Board")
    public void copyBoardToTeamWithSameTitle() {
        BoardPage boardPage = new BoardPage();
        MenuBoardPage menuBoardPage = new MenuBoardPage();
        menuBoardPage.openMoreOption();
        MoreOptionMenu moreOptionMenu = new MoreOptionMenu();
        moreOptionMenu.openCopyBoardSection();
        CopyBoardSection copyBoardSection = new CopyBoardSection();
        MenuBoardPage menuBoardPage1 = copyBoardSection.copyBoard(context.getBoard().getName(), context.getTeam().getName());
    }

    /**
     * Sees the name of owner boards is the name team.
     */
    @Then("I should see that this Board belongs to Team")
    public void seeBoardBelongsToTeam() {
        TopMenuBoardContent topMenuBoardContent = new TopMenuBoardContent();
        System.out.println(topMenuBoardContent.getNameOwnerBoardButton() + " boardPage###################");
        System.out.println(context.getTeam().getName() + " context###################");
        Assert.assertEquals(topMenuBoardContent.getNameOwnerBoardButton(), context.getTeam().getName(),
                "This name of Team not exist");
    }
}
