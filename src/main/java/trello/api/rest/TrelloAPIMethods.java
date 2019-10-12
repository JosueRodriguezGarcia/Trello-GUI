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
import trello.api.rest.Authentication;
import trello.api.rest.RestClientAPI;

import java.util.HashMap;
import java.util.Map;

/**
 * TrelloAPIMethods class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */

public class TrelloAPIMethods {

    private Response response;
    private RestClientAPI request;

    /**
     * Initializes and construct the HTTP request.
     */
    public TrelloAPIMethods() {
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    /**
     * Creates a board with the given name.
     *
     * @param name is the title to be assigned to the board.
     * @return the id of the created board.
     */
    public String createBoard(final String name) {
        String endPoint = "/boards/";
        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        request.buildSpec(data);
        response = request.post(endPoint);
        return response.getBody().jsonPath().get("id");
    }

    /**
     * Creates a board with the given name and without default lists.
     *
     * @param name is the title to be assigned to the board.
     * @return the id of the created board.
     */
    public String createBoardWODefaultLists(final String name) {
        String endPoint = "/boards/";
        String dataJson = "{\"name\":\"%s\"," +
                "\"defaultLists\":false}";
        request.buildSpec(String.format(dataJson, name));
        response = request.post(endPoint);
        return response.getBody().jsonPath().get("id");
    }

    /**
     * Deletes a board by id.
     *
     * @param id is the id of the board to be deleted.
     */
    public void deleteBoard(final String id) {
        String endPoint = "/boards/".concat(id);
        response = request.delete(endPoint);
    }

    /**
     * Creates a list with the given title.
     *
     * @param boardId   is the board where the list will be created in.
     * @param listTitle is the title to be assigned to the list.
     * @return is the id of the created list.
     */
    public String createList(final String boardId, final String listTitle) {
        String endPoint = "/lists";
        Map<String, String> data = new HashMap<>();
        data.put("name", listTitle);
        data.put("idBoard", boardId);
        request.buildSpec(data);
        response = request.post(endPoint);
        return response.getBody().jsonPath().get("id");
    }

    /**
     * Creates a card with the given title.
     *
     * @param listId    is the id of the list where the the card will be created in.
     * @param cardTitle is the title to be assigned to the card.
     * @return the id of the create card.
     */
    public String createCard(final String listId, final String cardTitle) {
        String endPoint = "/cards/";
        Map<String, String> data = new HashMap<>();
        data.put("name", cardTitle);
        data.put("idList", listId);
        request.buildSpec(data);
        response = request.post(endPoint);
        return response.jsonPath().get("id");
    }
}
