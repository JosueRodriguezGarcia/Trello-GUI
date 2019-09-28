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

import core.selenium.util.JsonConverter;
import core.selenium.util.ReadJsonFile;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import trello.entities.User;
import trello.keys.NamePages;

/**
 * RestClientAPI class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public final class RestClientAPI {

    private static RestClientAPI oauth;
    private RequestSpecification request;

    /**
     * This is constructor that initializes variables.
     */
    private RestClientAPI() {
        User user = JsonConverter.jsonToUser(ReadJsonFile.getInstance().getDataByUserType("admin"));
        String consumerKey = user.getConsumerKey();
        String consumerSecret = user.getConsumerSecret();
        String accessToken = user.getAccessToken();
        String tokenSecret = user.getTokenSecret();
        String baseUrl = NamePages.getBaseUrlAPI();
        request = new RequestSpecBuilder().setAuth(RestAssured.oauth(consumerKey, consumerSecret,
                accessToken, tokenSecret)).setBaseUri(baseUrl).build();
    }

    /**
     * Gives the class instance according Singleton pattern.
     *
     * @return an instance.
     */
    public static RestClientAPI getInstance() {
        if (oauth == null) {
            oauth = new RestClientAPI();
        }
        return oauth;
    }

    /**
     * Gives the request specification resultant of oauth.
     *
     * @return an request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return request;
    }
}
