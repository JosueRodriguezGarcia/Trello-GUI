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
 * CardAPIHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.2
 */
public class CardAPIHook {

    private Context context;
    private TrelloAPIMethods trelloAPIMethods;

    /**
     * Constructor method initializes the attributes.
     *
     * @param context initializes context attribute.
     */
    public CardAPIHook(final Context context) {
        this.context = context;
        trelloAPIMethods = new TrelloAPIMethods();
    }

    /**
     * Creates a Board with a list. used for add a card.
     */
    @Before(value = "@CreateCard")
    public void createBoardWithList() {
        String idBoard = trelloAPIMethods.createBoardWODefaultLists("BoardForCard");
        context.getBoard().setId(idBoard);
        String idList = trelloAPIMethods.createList(context.getBoard().getId(), "ListForCard");
        context.getList().setId(idList);
    }

    /**
     * Deletes the board that is in the context.
     */
    @After(value = "@CreateCard, @AssignChecklist, @AssignDueDate, @AssignMembers", order = 0)
    public void deleteBoard() {
        trelloAPIMethods.deleteBoard(context.getBoard().getId());
    }

    /**
     * Creates a Board with a list and a card. Used for add a checklist.
     */
    @Before(value = "@AssignChecklist")
    public void createCardForChecklist() {
        String idBoard = trelloAPIMethods.createBoardWODefaultLists("BoardForCard");
        context.getBoard().setId(idBoard);
        String idList = trelloAPIMethods.createList(context.getBoard().getId(), "ListForCard");
        context.getList().setId(idList);
        String idCard = trelloAPIMethods.createCard(context.getList().getId(), "CardForChecklist");
        context.getCard().setId(idCard);
    }

    /**
     * Creates a Board with a list and a card. Used for assign a due date.
     */
    @Before(value = "@AssignDueDate")
    public void createCardForDueDate() {
        String idBoard = trelloAPIMethods.createBoardWODefaultLists("BoardForCard");
        context.getBoard().setId(idBoard);
        String idList = trelloAPIMethods.createList(context.getBoard().getId(), "ListForCard");
        context.getList().setId(idList);
        String idCard = trelloAPIMethods.createCard(context.getList().getId(), "CardForDueDate");
        context.getCard().setId(idCard);
    }

    /**
     * Creates a Board with a list and a card. used for add members.
     */
    @Before(value = "@AssignMembers")
    public void createCardAddMembers() {
        String idBoard = trelloAPIMethods.createBoardWODefaultLists("BoardForCard");
        context.getBoard().setId(idBoard);
        String idList = trelloAPIMethods.createList(context.getBoard().getId(), "ListForCard");
        context.getList().setId(idList);
        String idCard = trelloAPIMethods.createCard(context.getList().getId(), "CardAddMembers");
        context.getCard().setId(idCard);
        String[] members = {"5d8193194e32bb68987c99f7", "5d83941066e73463ea07bb10"};
        trelloAPIMethods.addMembersToBoard(context.getBoard().getId(), members);
    }
}
