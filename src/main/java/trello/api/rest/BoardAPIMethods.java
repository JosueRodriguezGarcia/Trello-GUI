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
 * BoardAPIMethods class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class BoardAPIMethods {

    private RestClientAPI request;

    /**
     * Initializes and construct the HTTP request.
     */
    public BoardAPIMethods() {
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Creates a board with a nameBoard parameter.
     *
     * @param nameBoard is to set the name of board.
     * @return a response with the name board.
     */
    public Response createBoard(final String nameBoard) {
        String endPoint = "/boards";
        Map<String, String> data = new HashMap<>();
        data.put("name", nameBoard);
        request.buildSpec(data);
        return request.post(endPoint);
    }

    /**
     * Deletes the board use the idBoard parameter.
     *
     * @param idBoard is to search the board.
     */
    public void deleteTeam(final String idBoard) {
        String endPoint = "/boards/".concat(idBoard);
        request.delete(endPoint);
    }
}
