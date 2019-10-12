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

package core.selenium.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * JsonFileReader class, read the file of users.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public final class JsonFileReader {

    private static JsonFileReader readJsonFile;
    private JsonArray account;

    /**
     * Constructor of JsonFileReader class.
     */
    private JsonFileReader() {
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader("./user.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            account = jsonObject.getAsJsonArray("users");
        } catch (FileNotFoundException fe) {
            throw new RuntimeException("This file's path not exist" + fe);
        }
    }

    /**
     * Gets only instance of JsonFileReader class.
     *
     * @return a JsonFileReader object.
     */
    public static JsonFileReader getInstance() {
        if (readJsonFile == null) {
            readJsonFile = new JsonFileReader();
        }
        return readJsonFile;
    }

    /**
     * Gets user data according to given user type.
     *
     * @param userType is the type of requested user.
     * @return data of the requested user.
     */
    public JsonObject getDataByUserType(final String userType) {
        JsonObject userData = new JsonObject();
        for (Object object : account) {
            JsonObject dataAccount = (JsonObject) object;
            if (dataAccount.has(userType)) {
                userData = dataAccount.get(userType).getAsJsonObject();
                break;
            }
        }
        return userData;
    }
}
