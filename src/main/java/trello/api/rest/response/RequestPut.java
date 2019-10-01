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

package trello.api.rest.response;

import io.restassured.response.Response;
import trello.api.rest.RequestManager;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RequestPut class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class RequestPut extends RequestManager {

    /**
     * Constructor Method initializes the attributes.
     */
    public RequestPut() {
        super.initializes();
    }

    /**
     * Makes the request put type.
     *
     * @return a response to put.
     */
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                contentType(JSON).
                body(getData()).
                when().
                put(getEndPoint());
    }
}
