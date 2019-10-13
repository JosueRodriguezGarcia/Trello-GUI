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

package hooks.api;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import trello.api.rest.TrelloAPIMethods;
import trello.entities.Context;

/**
 * ListAPIHook class.
 *
 * @author Josue Rodriguez, Melissa Román
 * @version 0.0.1
 */
public class ListAPIHook {

    private Context context;
    private TrelloAPIMethods trelloAPIMethods;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public ListAPIHook(final Context context) {
        this.context = context;
        trelloAPIMethods = new TrelloAPIMethods();
    }

    /**
     * Makes a requestBoard for create a List.
     */
    @Before("@CreateList")
    public void createBoard() {
        String boardId = trelloAPIMethods.createBoardWODefaultLists("BoardForList");
        context.getBoard().setId(boardId);
    }

    /**
     * Deletes the board that is in the context.
     */
    @After(value = "@CreateList, @MoveAllCards, @SortCardsByName, @CopyACard", order = 0)
    public void deleteBoard() {
        trelloAPIMethods.deleteBoard(context.getBoard().getId());
    }

    /**
     * Creates two list with random cards. Used for move all cards and sort cards scenarios.
     */
    @Before("@MoveAllCards, @SortCardsByName")
    public void createTwoListAndRandomCards() {
        final int cardsQuantity = 4;
        String boardId = trelloAPIMethods.createBoardWODefaultLists("MoveSortBoard");
        context.getBoard().setId(boardId);
        String sourceListId = trelloAPIMethods.createList(boardId, "SourceList");
        trelloAPIMethods.createRandomCards(sourceListId, cardsQuantity);
        trelloAPIMethods.createList(boardId, "TargetList");
    }

    /**
     * Creates two list, one with specific cards. Used for copy a card scenario.
     */
    @Before("@CopyACard")
    public void createTwoListAndCards() {
        String boardId = trelloAPIMethods.createBoardWODefaultLists("CopyCardBoard");
        context.getBoard().setId(boardId);
        String sourceListId = trelloAPIMethods.createList(boardId, "SourceList");
        trelloAPIMethods.createCard(sourceListId, "Card2");
        trelloAPIMethods.createCard(sourceListId, "Card1");
        trelloAPIMethods.createList(boardId, "TargetList");
    }
}
