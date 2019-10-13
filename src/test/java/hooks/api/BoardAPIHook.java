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
import io.restassured.response.Response;
import trello.api.rest.TrelloAPIMethods;
import trello.entities.Context;

/**
 * BoardHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class BoardAPIHook {

    private Context context;
    private TrelloAPIMethods trelloAPIMethods;
    private Response response;
    private final int orderAfter = 3;
    private final int orderBefore = 1;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public BoardAPIHook(final Context context) {
        this.context = context;
        trelloAPIMethods = new TrelloAPIMethods();
    }

    /**
     * Makes a requestBoard for delete a Board by id.
     */
    @After(order = orderAfter, value = "@DeleteBoard")
    public void afterScenario() {
        trelloAPIMethods.deleteBoard(context.getBoard().getId());
    }

    /**
     * Makes a requestBoard for create a Board.
     */
    @Before(order = orderBefore, value = "@CreateBoard")
    public void beforeScenario() {
        response = trelloAPIMethods.createBoardGetResponse("Board to test");
        context.getBoard().setId(response.jsonPath().get("id"));
    }
}
