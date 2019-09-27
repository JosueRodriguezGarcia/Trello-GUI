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
 * User class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class User {

    private String username;
    private String password;
    private String fullName;
    private String email;
    private String consumerKey;
    private String consumerSecret;
    private String accessToken;
    private String tokenSecret;

    /**
     * Method constructor empty of User class.
     */
    public User() {
    }

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
    public String getFullNameInitials() {
        String res = "";
        String[] splitName = getFullName().split("\\s+");
        for (String initLetter : splitName) {
            res = res + initLetter.substring(0, 1).toUpperCase();
        }
        return res;
    }

    /**
     * Sets username to the user.
     *
     * @param username is the username to be set.
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Sets password to the user.
     *
     * @param password is the password to be used.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Sets full name to the user.
     *
     * @param fullName is the full name to be set.
     */
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    /**
     * Sets email to the user.
     *
     * @param email is the email to be set.
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the consumer key.
     *
     * @return the user's consumer key.
     */
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * Sets the consumer key to the user.
     *
     * @param consumerKey is the consumer key to be set.
     */
    public void setConsumerKey(final String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * Gets the consumer secret.
     *
     * @return the user's consumer secret.
     */
    public String getConsumerSecret() {
        return consumerSecret;
    }

    /**
     * Sets the consumer secret to the user.
     *
     * @param consumerSecret is the consumer key to be set.
     */
    public void setConsumerSecret(final String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    /**
     * Gets the access token.
     *
     * @return the user's access token.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token to the user.
     *
     * @param accessToken is the access token to be set.
     */
    public void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets the token secret.
     *
     * @return the user's token secret.
     */
    public String getTokenSecret() {
        return tokenSecret;
    }

    /**
     * Sets the token secret to the user.
     *
     * @param tokenSecret is the token secret to be set.
     */
    public void setTokenSecret(final String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }
}
