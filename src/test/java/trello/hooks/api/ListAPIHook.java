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

import cucumber.api.java.Before;
import io.restassured.response.Response;
import trello.api.rest.Authentication;
import trello.api.rest.RestClientAPI;
import trello.entities.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * ListAPIHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class ListAPIHook {

    private Context context;
    private Response response;
    private RestClientAPI request;
    private final int orderBefore = 2;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public ListAPIHook(final Context context) {
        this.context = context;
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Makes a requestBoard for create a List.
     */
    @Before(order = orderBefore, value = "@create-list")
    public void beforeScenario() {
        String idBoard = context.getBoard().getId();
        Map<String, String> data = new HashMap<>();
        data.put("name", "TestList");
        data.put("idBoard", idBoard);
        request.buildSpec(data);
        response = request.post("/lists/");
        context.getList().setId(response.getBody().jsonPath().get("id"));
    }
}




