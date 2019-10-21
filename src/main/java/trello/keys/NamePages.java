/*
 * Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package trello.keys;

/**
 * NamePages class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public final class NamePages {

    private static final String BASE_URL = "https://trello.com";
    private static final String BASE_URL_API = "https://api.trello.com/1";

    /**
     * Empty constructor requested by checkstyle.
     */
    private NamePages() {

    }

    /**
     * Gets home page URL.
     *
     * @param username is the username of the user.
     * @return the home page URL.
     */
    public static String getHomePageUrl(final String username) {
        return BASE_URL + "/" + username + "/boards";
    }

    /**
     * Gets the uri of login page.
     *
     * @return as string the uri of login page.
     */
    public static String getLoginPageUrl() {
        return BASE_URL + "/login";
    }

    /**
     * Gets the base url.
     *
     * @return as string the base url.
     */
    public static String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * Gets the uri of API.
     *
     * @return as string  the uri of API.
     */
    public static String getBaseUrlAPI() {
        return BASE_URL_API;
    }
}
