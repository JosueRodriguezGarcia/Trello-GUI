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
 * Context class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public class List {

    private String title;

    /**
     * Sets the list title.
     *
     * @param title is the name that will be set to the title.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets the list's title.
     *
     * @return the title of the list.
     */
    public String getTitle() {
        return title;
    }
}
