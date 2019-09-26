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
package core.selenium.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import trello.entities.User;

/**
 * Implements JsonConverter abstract class which is used to convert json records in DB.
 *
 * @author Melissa Román
 * @version 1.0
 */
public final class JsonConverter {

    /**
     * Empty constructor requested by checkstyle.
     */
    private JsonConverter() {

    }

    /**
     * Converts a jsonObject to User.
     * @param userData is the data that will be converted to User object.
     * @return a User object.
     */
    public static User jsonToUser(JsonObject userData) {
        Gson gson = new Gson();
        return gson.fromJson(userData, User.class);
    }
}
