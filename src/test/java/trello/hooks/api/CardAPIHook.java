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
 * CardAPIHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class CardAPIHook {
    private Context context;
    private Response response;
    private RequestManager requestManager;

    /**
     * Constructor method initializes the attributes.
     *
     * @param context initializes context attribute.
     */
    public CardAPIHook(final Context context) {
        this.context = context;
    }

    /**
     * Makes a request for delete a Card by id.
     */
    @After("@delete-card")
    public void afterScenario() {
        String id = context.getBoard().getId();
        String endPoint = "/cards/".concat(id);
        String method = "delete";
        requestManager = RequestFactory.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        response = requestManager.makeRequest();
        Log.getInstance().getLogger().info(response);
    }

    /**
     * Makes a request for create a Card.
     */
    @Before("@create-card")
    public void beforeScenario() {
        String endPoint = "/cards/";
        String method = "post";
        String name = "testCard";
        String idList = context.getList().getId();
        String data = "{ \"name\":\"" + name + "\" ,"
                + "\"idList\":\"" + idList + "\"}";
        requestManager = RequestFactory.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Log.getInstance().getLogger().info(response);
        context.getCard().setId(response.jsonPath().get("id"));
    }
}
