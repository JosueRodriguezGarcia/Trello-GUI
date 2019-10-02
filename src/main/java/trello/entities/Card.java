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

/**
 * Card class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class Card {

    private String id;
    private String title;

    /**
     * This method is used to get id.
     *
     * @return a string with the id of card.
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to set id.
     *
     * @param id defines of input string with the id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * This method is used get title.
     *
     * @return a string with the title of card.
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method is used to set title.
     *
     * @param title defines of input string with the title.
     */
    public void setTitle(final String title) {
        this.title = title;
    }
}
