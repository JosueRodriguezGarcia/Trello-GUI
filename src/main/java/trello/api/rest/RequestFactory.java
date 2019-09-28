/*
 * @(#) RunCukesTest.java Copyright (c) 2019 Jala Foundation.
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

import trello.api.rest.response.RequestDelete;
import trello.api.rest.response.RequestGet;
import trello.api.rest.response.RequestPost;
import trello.api.rest.response.RequestPut;

import java.util.HashMap;
import java.util.Map;

/**
 * RequestFactory class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public final class RequestFactory {
    private static Map<String, RequestManager> requestMap = new HashMap<>();

    /**
     *Private constructor requested by checkstyle.
     */
    private RequestFactory() {

    }

    static {
        requestMap.put("GET", new RequestGet());
        requestMap.put("PUT", new RequestPut());
        requestMap.put("POST", new RequestPost());
        requestMap.put("DELETE", new RequestDelete());
    }

    /**
     * Gets a RequestManager.
     *
     * @param method defines an  imput string with type the request.
     * @return a RequestManager.
     */
    public static RequestManager getRequest(final String method) {
        return requestMap.get(method.toUpperCase());
    }
}
