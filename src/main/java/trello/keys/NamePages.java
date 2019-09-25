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

import trello.entities.Context;
import trello.entities.User;

/**
 * NamePages class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class NamePages {

    private User user;
    private static final String BASE_URL = "https://trello.com";

    /**
     * Constructor method for share states between objects.
     *
     * @param context has all share entities.
     */
    public NamePages(final Context context) {
        this.user = context.getUser();
    }

    /**
     * Gets the uri of home page.
     *
     * @return as string the uri of home page.
     */
    public String getHomePage() {
        return BASE_URL + "/" + user.getUsername() + "/boards";

    }

    /**
     * Gets the uri of login page.
     *
     * @return as string the uri of login page.
     */
    public String getLoginPage() {
        return BASE_URL + "/login";
    }

    /**
     * Gets the uri of login page.
     *
     * @return as string the uri of login page.
     */
    public String getAtlassianPage() {
        return "https://id.atlassian.com/login?application=trello&continue=https%3A%2F%2Fauth.atlassian.com%2Fauthorize%3Fclient_id%3DmQz6pdKujUewiC7UYHDic39K2ruzZ400%26scope%3Dopenid%2520email%2520profile%26response_type%3Dcode%26redirect_uri%3Dhttps%253A%252F%252Ftrello.com%252Fauth%252Fcallback%26state%3DreturnUrl%253D%25252F%2526provider%253Datlassian%2526locale%253Den-US%2526tosAccepted%253D%2526confirmNew%253D1%2526csrf%253DfpFu4XEsHPR9HH0owAUi5nV51t2m31DR1%25252BjisQ7jfnE%25253D&prompt=select_account";
    }
}
