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
 * CardAPIHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class CardAPIHook {

    private Context context;
    private Response response;
    private RestClientAPI request;
    private final int orderAfter = 1;
    private final int orderBefore = 3;

    /**
     * Constructor method initializes the attributes.
     *
     * @param context initializes context attribute.
     */
    public CardAPIHook(final Context context) {
        this.context = context;
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Makes a requestBoard for delete a Card by id.
     */
    @After(order = orderAfter, value = "@delete-card")
    public void afterScenario() {
        String id = context.getCard().getId();
        String endPoint = "/cards/".concat(id);
        response = request.delete(endPoint);
    }

    /**
     * Makes a requestBoard for create a Card.
     */
    @Before(order = orderBefore, value = "@create-card")
    public void beforeScenario() {
        String endPoint = "/cards/";
        String idList = context.getList().getId();
        Map<String, String> data = new HashMap<>();
        data.put("name", "CardTest");
        data.put("idList", idList);
        request.buildSpec(data);
        response = request.post(endPoint);
        context.getCard().setId(response.jsonPath().get("id"));
    }
}
