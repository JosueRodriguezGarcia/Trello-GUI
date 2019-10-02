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
import cucumber.api.java.Before;
import io.restassured.response.Response;
import trello.api.rest.RequestFactory;
import trello.api.rest.RequestManager;
import trello.entities.Context;

/**
 * ListAPIHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class ListAPIHook {

    private Context context;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public ListAPIHook(final Context context) {
        this.context = context;
    }

    /**
     * Makes a request for create a List.
     */

    @Before("@create-list")
    public void beforeScenario() {
        String endPoint = "/lists/";
        String method = "post";
        String name = "TestList";
        String idBoard = context.getBoard().getId();
        String data = "{ \"name\":\"" + name + "\" ,"
                + "\"idBoard\":\"" + idBoard + "\"}";
        RequestManager requestManager = RequestFactory.getRequest(method);
        requestManager.setMethod(method);
        requestManager.setEndPoint(endPoint);
        requestManager.setData(data);
        Response response = requestManager.makeRequest();
        Log.getInstance().getLogger().info(response);
        context.getListSource().setId(response.jsonPath().get("id"));
    }
}




