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

import core.selenium.util.ReadJsonFile;

/**
 * User class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class User {

    private String username;
    private String  password;
    private String fullName;
    private String email;

    /**
     * Method constructor of User class.
     *
     * @param userType to create a user instance.
     */
    public void initialize(final String userType) {
        username = ReadJsonFile.getInstance(userType.toLowerCase()).getUsername();
        password = ReadJsonFile.getInstance(userType.toLowerCase()).getPassword();
        fullName = ReadJsonFile.getInstance(userType.toLowerCase()).getFullName();
        email = ReadJsonFile.getInstance(userType.toLowerCase()).getEmail();
    }

    /**
     * Method constructor empty of User class.
     */
    public User() { }

    /**
     * Gets the user name attribute of its class.
     *
     * @return as string the user name attribute.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password attribute of its class.
     *
     * @return as string the password attribute.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the fullName attribute of its class.
     *
     * @return as string the fullName attribute.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Gets the email attribute of its class.
     *
     * @return as string the email attribute.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Gets the initial of full name attribute of this class.
     *
     * @return as string the initial full name attribute.
     */
    public String getInitialFullName() {
        String res = "";
        String[] splitName = getFullName().split("\\s+");
        for (String initLetter: splitName) {
            res = res + initLetter.substring(0, 1).toUpperCase();
        }
        return res;
    }
}
