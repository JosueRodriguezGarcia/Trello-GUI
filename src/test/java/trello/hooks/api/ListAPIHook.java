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
    @Before("@ArchivesList")
    public void createBoard() {
        String endPoint = "/boards/";
        String name = "TestBoard";
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        request.buildSpec(data);
        response = request.post(endPoint);
        context.getBoard().setId(response.getBody().jsonPath().get("id"));
    }

    @After("@ArchivesList")
    public void deleteBoard() {
        String endPoint = "/boards/";
        String name = "TestBoard";
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        request.buildSpec(data);
        response = request.post(endPoint);
        context.getBoard().setId(response.getBody().jsonPath().get("id"));
    }

    @After("@ArchivesList")
    public void afterScenario() {
        String id = context.getBoard().getId();
        String endPoint = "/boards/".concat(id);
        response = request.delete(endPoint);
    }
}




