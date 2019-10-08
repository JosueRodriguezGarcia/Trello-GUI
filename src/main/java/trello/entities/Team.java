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

import java.util.ArrayList;
import java.util.List;

/**
 * Team class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Team {

    private String id;
    private String name;
    private List<String> userNameOfMembers;

    /**
     * Constructor of object of it's class.
     */
    public Team() {
        userNameOfMembers = new ArrayList<String>();
    }

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
    public void setId(final String id) {
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
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the userNameOfMembers list attribute.
     *
     * @return a object List of this class.
     */
    public List<String> getUserNameOfMembers() {
        userNameOfMembers.sort(String::compareTo);
        return userNameOfMembers;
    }

    /**
     * Sets the usernameOfMembers list attribute of this class.
     *
     * @param usernameMembers is to set new value in usernameOfMembers attribute.
     */
    public void setUsernameOfMember(final List<String> usernameMembers) {
        for (String usernameMember : usernameMembers) {
            userNameOfMembers.add(usernameMember);
        }
    }

    /**
     * Add member to the member list.
     *
     * @param usernameMember is member to add member list.
     */
    public void addMember(final String usernameMember) {
        userNameOfMembers.add(usernameMember);
    }
}
