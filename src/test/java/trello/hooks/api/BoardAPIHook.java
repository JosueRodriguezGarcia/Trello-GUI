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

package trello.hooks.api;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
import trello.api.rest.Authentication;
import trello.api.rest.RestClientAPI;
import trello.entities.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * BoardHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class BoardAPIHook {

    private Context context;
    private Response response;
    private RestClientAPI request;
    private final int orderAfter = 3;
    private final int orderBefore = 1;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public BoardAPIHook(final Context context) {
        this.context = context;
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Makes a requestBoard for delete a Board by id.
     */
    @After(order = orderAfter, value = "@delete-board")
    public void afterScenario() {
        String id = context.getBoard().getId();
        String endPoint = "/boards/".concat(id);
        response = request.delete(endPoint);
    }

    /**
     * Makes a requestBoard for create a Board.
     */
    @Before(order = orderBefore, value = "@create-board")
    public void beforeScenario() {
        String endPoint = "/boards/";
        String name = "Test Board";
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        request.buildSpec(data);
        response = request.post(endPoint);
        context.getBoard().setId(response.getBody().jsonPath().get("id"));
        context.getBoard().setUrl(response.getBody().jsonPath().get("url"));
    }

//    /**
//     * Makes a requestBoard for create a Board to test of create Card.
//     */
//    @Before(order = orderBefore, value="@create-board-empty")
//    public void beforeScenarioToCreateCard() {
//        String endPoint = "/boards/";
//        String name = "Board to create Card";
//        Map<String, String> data = new HashMap<>();
//        data.put("name", name);
//        request.buildSpec(data);
//        response = request.post(endPoint);
//        context.getBoardToCard().setId(response.getBody().jsonPath().get("id"));
//        context.getBoardToCard().setUrl(response.getBody().jsonPath().get("url"));
//
//    }

    /**
     * Makes a requestBoard for create a Board to test of create Card.
     */
    @After(order = orderAfter, value ="@delete-board-empty")
    public void afterScenarioToCreateCard() {
        String id = context.getBoardToCard().getId();
        String endPoint = "/boards/".concat(id);
        response = request.delete(endPoint);
    }
}


