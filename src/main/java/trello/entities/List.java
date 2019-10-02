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

package trello.entities;

import cucumber.api.java.bs.A;

import java.util.ArrayList;

/**
 * Context class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public class List {

    private String id;
    private String title;
    private ArrayList<Card> cards;

    public List() {
        cards = new ArrayList<>();
    }

    /**
     * Sets the list title.
     *
     * @param listTitle is the name that will be set to the title.
     */
    public void setTitle(final String listTitle) {
        this.title = listTitle;
    }

    /**
     * Gets the list's title.
     *
     * @return the title of the list.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the id attribute of its class.
     *
     * @return as string the id attribute.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id to the user.
     *
     * @param id is the username to be set.
     */
    public void setId(final String id) {
        this.id = id;
    }

    public void setCards(final ArrayList<Card> cards) {
        this.cards = cards;
    }
}
