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
import trello.api.rest.RequestFactory;
import trello.api.rest.RequestManager;
import trello.entities.Context;

/**
 * BoardHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class BoardAPIHook {

    private Context context;
    private Response response;
    private RequestManager requestManager;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public BoardAPIHook(final Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Board by id.
     */
    @After("@delete-board")
    public void afterScenario() {
        String id = context.getBoard().getId();
        String endPoint = "boards/".concat(id);
        String method = "delete";
        requestManager = RequestFactory.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setMethod(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLogger().info(response);
    }

    /**
     * Makes a request for create a Board.
     */
    @Before("@create-board")
    public void beforeScenario() {
        String endPoint = "/boards/";
        String method = "post";
        String name = "TestBoard02";
        String data = "{ \"name\":\"" + name + "\"}";
        requestManager = RequestFactory.getRequest(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setMethod(method);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLogger().info(response);
        context.getBoard().setId(response.jsonPath().get("id"));
    }
}


