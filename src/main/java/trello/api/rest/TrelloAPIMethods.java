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

import com.github.javafaker.Faker;

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
        String dataJson = "{\"name\":\"%s\","
                + "\"defaultLists\":false}";
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
     * Creates a board with a nameBoard parameter.
     *
     * @param nameBoard is to set the name of board.
     * @return a response with the name board.
     */
    public Response createBoardGetResponse(final String nameBoard) {
        String endPoint = "/boards";
        Map<String, String> data = new HashMap<>();
        data.put("name", nameBoard);
        request.buildSpec(data);
        return request.post(endPoint);
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

    /**
     * Creates given quantity of random cards on given list.
     *
     * @param listID is de id of the list where the cards will be created.
     * @param qty    is the quantity of cards to be created.
     */
    public void createRandomCards(final String listID, final int qty) {
        for (int index = 0; index < qty; index++) {
            Faker faker = new Faker();
            String cardTitle = faker.job().keySkills();
            createCard(listID, cardTitle);
        }
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

    /**
     * Adds members to board.
     *
     * @param boardId is de id of the board where the members will be adding.
     */
    public void addMembersToBoard(final String boardId, final String[] members) {
        Map<String, String> data = new HashMap<>();
        data.put("type", "normal");
        for (String member : members) {
            String endPoint = "/boards/" + boardId + "/members/" + member;
            request.buildSpec(data);
            response = request.put(endPoint);
        }
    }
}
