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
import io.restassured.specification.RequestSpecification;

/**
 * RequestManager class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public abstract class RequestManager {

    private String endPoint;
    private String data;
    private String method;

    /**
     * Constructor method initializes the attributes.
     */
    public void initializes() {
        this.endPoint = "";
        this.data = "";
        this.method = "";
    }

    /**
     * Gets a data of type string with the endPoint.
     *
     * @return as string the endpoint attribute.
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * Sets endpoint to the RequestManager.
     *
     * @param endPoint is the string endpoint to be set.
     */
    public void setEndPoint(final String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Gets the data.
     *
     * @return an string the data attribute.
     */
    public String getData() {
        return data;
    }

    /**
     * Sets data to the RequestManager.
     *
     * @param data is the string data to be set.
     */
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * Gets the method.
     *
     * @return an string the method attribute.
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method to the RequetManager.
     *
     * @param method is the method to be set.
     */
    public void setMethod(final String method) {
        this.method = method;
    }

    /**
     * Gets the RequestSpecification.
     *
     * @return an instance of RequestSpecification.
     */
    public RequestSpecification getRequest() {
        return RestClientAPI.getInstance().getRequestSpecification();
    }

    /**
     * Defines the method makeRequest.
     *
     * @return a Response.
     */
    public abstract Response makeRequest();
}
