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
 * Board class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Board {
    private String id;
    private int number;
    private String name;

    /**
     * Gets the id attribute of its class.
     *
     * @return as string the id attribute.
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the number attribute of its class.
     *
     * @return as string the number attribute.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Gets the name attribute of its class.
     *
     * @return as string the name attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets id to the user.
     *
     * @param id is the username to be set.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * Sets number to the user.
     *
     * @param number is the username to be set.
     */
    public void setNumber(final int number) {
        this.number = number;
    }

    /**
     * Sets name to the user.
     *
     * @param name is the username to be set.
     */
    public void setName(final String name) {

        this.name = name;
    }
}
