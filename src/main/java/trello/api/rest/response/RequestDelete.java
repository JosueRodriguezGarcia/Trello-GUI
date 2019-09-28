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

/**
 * RequestDelete class.
 *
 * @author Josue Rodriguez.
 * @version 0.0.1
 */
public class RequestDelete extends RequestManager {

    /**
     * Constructor Method initializes the attributes.
     */
    public RequestDelete() {
        super.initializes();
    }

    /**
     * Makes the request delete type.
     *
     * @return a response to delete.
     */
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                when().
                delete(getEndPoint());
    }
}
