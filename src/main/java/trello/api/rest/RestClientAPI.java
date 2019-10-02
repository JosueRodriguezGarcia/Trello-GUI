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

import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RestClientAPI class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1.
 */
public class RestClientAPI {

    private RequestSpecification requestSpecification;

    /**
     * Constructor method.
     *
     * @param requestSpecification defines a requestSpecification for input.
     */
    public RestClientAPI(final RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Gets a response of type get.
     *
     * @param endpoint defines the type the http method.
     * @return a response.
     */
    public Response get(final String endpoint) {
        return apiResponse("GET", endpoint);
    }

    /**
     * Gets a response of type put.
     *
     * @param endpoint defines the type the http method.
     * @return a response.
     */
    public Response put(final String endpoint) {
        return apiResponse("PUT", endpoint);
    }

    /**
     * Gets a response of type post.
     *
     * @param endpoint defines the type the http method.
     * @return a response.
     */
    public Response post(final String endpoint) {
        return apiResponse("POST", endpoint);
    }

    /**
     * Gets a response of type delete.
     *
     * @param endpoint defines the type the http method.
     * @return a response.
     */
    public Response delete(final String endpoint) {
        return apiResponse("DELETE", endpoint);
    }

    /**
     * Gets a requestSpecification for RestClientAPI.
     *
     * @return a requestSpecification.
     */
    public RequestSpecification getRequest() {
        return requestSpecification;
    }

    /**
     * Sets the attribute requestSpecification en RestClientAPI.
     *
     * @param requestSpecification defines a requestSpecification in attribute to be set.
     */
    public void setRequest(final RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    /**
     * Builds the request defines the method http and endpoint.
     *
     * @param httpMethod defines the type the http method.
     * @param endpoint   defines the endpoint.
     * @return a response.
     */
    private Response apiResponse(final String httpMethod, final String endpoint) {
        return given().
                spec(requestSpecification).
                when().
                request(httpMethod, endpoint);
    }

    /**
     * Builds the request with a body.
     *
     * @param body defines parameters od input in a map.
     */
    public void buildSpec(final Map<String, String> body) {
        requestSpecification = given().
                spec(requestSpecification).
                contentType(JSON).
                body(new Gson().toJson(body));

    }
}
