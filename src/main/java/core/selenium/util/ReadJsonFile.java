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
 * ReadJsonFile class, read the file of users.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public final class ReadJsonFile {

    private static ReadJsonFile readJsonFile;
    private JsonArray account;
    private JsonObject user;

    /**
     * Constructor of ReadJsonFile class.
     */
    private ReadJsonFile() {
        try {
            JsonParser parser = new JsonParser();
            JsonElement jsonElement = parser.parse(new FileReader("./user.json"));
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            account  = jsonObject.getAsJsonArray("users");
        } catch (FileNotFoundException fe) {
            throw new RuntimeException("This file's path not exist" + fe);
        }
    }

    /**
     * Gets only instance of ReadJsonFile class.
     *
     * @param userType uses to search the userType.
     * @return a ReadJsonFile object.
     */
    public static ReadJsonFile getInstance(final String userType) {
        if (readJsonFile == null) {
            readJsonFile = new ReadJsonFile();
        }
        readJsonFile.searchUserType(userType);
        return readJsonFile;
    }

    /**
     * Gets username of file json.
     *
     * @return as string username of a user.
     */
    public String getUsername() {
        return user.get("username").getAsString();
    }

    /**
     * Gets password of file json.
     *
     * @return as string password of a user.
     */
    public String getPassword() {
        return user.get("password").getAsString();
    }

    /**
     * Searches a user type of JsonArray.
     *
     * @param userType use to search a userType.
     */
    private void searchUserType(final String userType) {
        for (Object object: account) {
            JsonObject dataAccount = (JsonObject) object;
            if (dataAccount.has(userType)) {
                user = dataAccount.get(userType).getAsJsonObject();
                break;
            }
        }
    }
}
