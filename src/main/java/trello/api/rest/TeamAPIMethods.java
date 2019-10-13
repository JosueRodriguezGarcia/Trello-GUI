/*
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package trello.api.rest;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * TeamAPIMethods class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TeamAPIMethods {

    private RestClientAPI request;

    /**
     * Initializes and construct the HTTP request.
     */
    public TeamAPIMethods() {
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Creates a team with a nameTeam parameter.
     *
     * @param nameTeam is to set the name of team.
     * @return a response with the name team.
     */
    public Response createTeam(final String nameTeam) {
        String endPoint = "/organizations";
        Map<String, String> data = new HashMap<>();
        data.put("displayName", nameTeam);
        request.buildSpec(data);
        return request.post(endPoint);
    }

    /**
     * Deletes the team use the idTeam parameter.
     *
     * @param idTeam is to search the team.
     */
    public void deleteTeam(final String idTeam) {
        String endPoint = "/organizations/".concat(idTeam);
        request.delete(endPoint);
    }
}
