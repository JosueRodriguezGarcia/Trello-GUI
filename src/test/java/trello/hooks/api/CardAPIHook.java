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

import core.utils.Log;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.response.Response;
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
    RestClientAPI request;

    /**
     * Constructor method initializes the attributes.
     *
     * @param context initializes context attribute.
     */
    public CardAPIHook(final Context context) {
        this.context = context;
    }

    /**
     * Makes a requestBoard for delete a Card by id.
     */
    @After("@delete-card")
    public void afterScenario() {
        String id = context.getCard().getId();
        String endPoint = "/cards/".concat(id);
        response = request.delete(endPoint);
        Log.getInstance().getLogger().info(response);
    }

    /**
     * Makes a requestBoard for create a Card.
     */
    @Before("@create-card")
    public void beforeScenario() {
        String endPoint = "/cards/";
        String method = "post";
        String name = "testCard";
        String idList = context.getList().getId();
        Map<String, String> data =  new HashMap<>();
        data.put("name",name);
        data.put("idList",idList);
        request.buildSpec(data);
        response = request.post(endPoint);
        Log.getInstance().getLogger().info(response);
        context.getCard().setId(response.jsonPath().get("id"));
    }
}
