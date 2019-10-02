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

/**
 * Team class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Team {

    private String id;
    private String name;

    /**
     * Gets the id attribute of this class.
     *
     * @return as a string the id attribute.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id attribute for the parameter id.
     *
     * @param id is to set the id attribute.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the name attribute of this class.
     *
     * @return as a string the name attribute.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name attribute for the parameter name.
     *
     * @param name is to set the name attribute.
     */
    public void setName(String name) {
        this.name = name;
    }
}
