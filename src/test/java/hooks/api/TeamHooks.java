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
import io.restassured.response.Response;
import trello.api.rest.Authentication;
import trello.api.rest.RestClientAPI;
import trello.entities.Context;

/**
 * TeamHooks class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TeamHooks {

    private Context context;
    private Response response;
    private RestClientAPI request;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public TeamHooks(final Context context) {
        this.context = context;
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Makes the delete of team after it was created.
     */
    @After("@delete-team")
    public void afterScenario() {
        String idTeam = context.getTeam().getId();
        String endPoint = "/organizations/".concat(idTeam);
        response = request.delete(endPoint);
    }
}
