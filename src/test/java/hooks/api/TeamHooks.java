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
import cucumber.api.java.Before;
import io.restassured.response.Response;
import trello.api.rest.TeamAPIMethods;
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
    private TeamAPIMethods teamAPIMethods;

    /**
     * This method constructor initializes the variables.
     *
     * @param context initializes context attribute.
     */
    public TeamHooks(final Context context) {
        this.context = context;
        teamAPIMethods = new TeamAPIMethods();
    }

    /**
     * Makes a requestBoard for create a Board.
     */
    @Before("@CreateTeam")
    public void beforeScenario() {
        response = teamAPIMethods.createTeam("Team to test");
        context.getTeam().setId(response.getBody().jsonPath().get("id"));
        context.getTeam().setName(response.getBody().jsonPath().get("displayName"));
    }

    /**
     * Makes the delete of team after it was created.
     */
    @After("@DeleteTeam")
    public void afterScenario() {
        teamAPIMethods.deleteTeam(context.getTeam().getId());
    }
}
