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
 * MemberAPIHook class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class MemberAPIHook {

    private Context context;
    private Response response;
    private RestClientAPI request;
    private final int orderBefore = 4;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public MemberAPIHook(final Context context) {
        this.context = context;
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Makes a request for add members to board.
     */
    @Before(order = orderBefore, value = "@add-member")
    public void beforeScenario() {
        String idBoard = context.getBoard().getId();
        String[] members = {"5d8193194e32bb68987c99f7", "5d83941066e73463ea07bb10", "5d839a3202eee76812c1c783"};
        Map<String, String> data = new HashMap<>();
        data.put("type", "normal");
        for (int i = 0; i < members.length; i++) {
            String endPoint = "/boards/" + idBoard + "/members/" + members[i];
            request.buildSpec(data);
            response = request.put(endPoint);
        }
    }
}
