/*
 * @(#) Logger.java Copyright (c) 2019 Jala Foundation.
 * 2643 Av. Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */
package core.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Log class is used to log as singleton.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public final class Log {
    private static Logger logger = Logger.getLogger(Log.class);
    private static Log loggerInstance;

    /**
     * Initializes LogManager.
     */
    private Log() {
        initLogManager();
    }

    /**
     * Sets configurations for log and the level.
     */
    public void initLogManager() {
        PropertyConfigurator.configure("log4j.properties");
        logger.setLevel(Level.ALL);
    }

    /**
     * Allows to get the only instance of LogManager.
     *
     * @return loggerInstance.
     */
    public static Log getInstance() {
        if (loggerInstance == null) {
            loggerInstance = new Log();
        }
        return loggerInstance;
    }

    /**
     * Allows to get the log.
     *
     * @return logger.
     */
    public Logger getLogger() {
        return logger;
    }
}
