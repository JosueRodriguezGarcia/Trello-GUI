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

package trello.entities;

import trello.ui.pages.HomePage;

/**
 * Context class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Context {

    private User user;
    private Board board;
    private List list;
    private HomePage homePage;

    /**
     * Method constructor of Context class.
     */
    public Context() {
        user = new User();
        list = new List();
        homePage = new HomePage();
    }

    /**
     * Gets User attribute of its class.
     *
     * @return the User attribute.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets context's user.
     *
     * @param user is the user to be shared in context.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Gets Board attribute of its class.
     *
     * @return the Board attribute.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Gets the context's list.
     *
     * @return the list that is on the context.
     */
    public List getList() {
        return list;
    }

    /**
     * Gets HomePage attribute of its class.
     *
     * @return the HomePage attribute.
     */
    public HomePage getHomePage() {
        return homePage;
    }

    /**
     * Sets context's user.
     *
     * @param homePage is the user to be shared in context.
     */
    public void setHomePage(final HomePage homePage) {
        this.homePage = homePage;
    }
}
