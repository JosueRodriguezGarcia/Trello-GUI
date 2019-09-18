/*
 * @(#) PropertiesReader.java Copyright (c) 2019 Jala Foundation.
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

import core.utils.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * PropertiesReader class is used to read properties files.
 *
 * @author Melissa Román
 * @version 1.0
 */
public abstract class PropertiesReader {

    /**
     * Allows to get properties from properties file.
     *
     * @param path - Path in which the properties file is located.
     * @return Properties.
     */
    public static Properties getProperties(final String path) {
        try (InputStream input = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException ioe) {
            Log.getInstance().getLogger().error(ioe + path + " could not be read.");
            throw new RuntimeException(ioe + path + " could not be read.");
        }
    }
}
