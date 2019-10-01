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
 * Authentication class.
 * @autor Josue Rodriguez Garcia.
 * @version 0.0.1.
 */
public class Authentication {

    public static RequestSpecification getRequestSpecification() {
        User user = JsonConverter.jsonToUser(ReadJsonFile.getInstance().getDataByUserType("admin"));
        String consumerKey = user.getConsumerKey();
        String consumerSecret = user.getConsumerSecret();
        String accessToken = user.getAccessToken();
        String tokenSecret = user.getTokenSecret();
        String baseUrl = NamePages.getBaseUrlAPI();
        return new RequestSpecBuilder().setAuth(RestAssured.oauth(consumerKey, consumerSecret,
                accessToken, tokenSecret)).setBaseUri(baseUrl).build();
    }
}
