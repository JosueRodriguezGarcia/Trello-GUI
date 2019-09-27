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

import trello.entities.User;

/**
 * NamePages class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public class NamePages {

    private User user;
    private static final String BASE_URL = "https://trello.com";

    /**
     * Constructs NamePages setting the given user.
     *
     * @param user is the user to be user to form the URLs.
     */
    public NamePages(final User user) {
        this.user = user;
    }

    /**
     * Gets the uri of home page.
     *
     * @return as string the uri of home page.
     */
    public String getHomePageUrl() {
        return BASE_URL + "/" + user.getUsername() + "/boards";
    }

    /**
     * Gets the uri of login page.
     *
     * @return as string the uri of login page.
     */
    public String getLoginPageUrl() {
        return BASE_URL + "/login";
    }
}
