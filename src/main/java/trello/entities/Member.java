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
 * Member class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */

public class Member {

    private String fullName;
    private String initials;

    /**
     * Gets the full name of member.
     *
     * @return a string with the full name.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the full name attribute.
     *
     * @param fullName defines the full name to be set.
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * Gets the initials of member.
     *
     * @return a string with the initials.
     */
    public String getInitials() {
        return initials;
    }

    /**
     * Sets the initials attribute.
     *
     * @param initials defines the initials to be set.
     */
    public void setInitials(final String initials) {
        this.initials = initials;
    }
}
