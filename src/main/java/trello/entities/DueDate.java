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

import core.selenium.util.DateMethod;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * DueDate class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class DueDate {

    private String date;
    private String time;
    private String reminder;

    /**
     * Gets the Due Date of a card.
     *
     * @return a String with the date of due date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the due date attribute of a card.
     *
     * @param date defines a input string with date to be set.
     */
    private void setDate(final String date) {
        this.date = date;
    }

    /**
     * Gets the time of a card.
     *
     * @return a string with a time of a card.
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the due time attribute of a card.
     *
     * @param time defines a input string with time to be set.
     */
    private void setTime(final String time) {
        this.time = time;
    }

    /**
     * Gets the reminder of a card.
     *
     * @return  a string with a reminder of a card.
     */
    public String getReminder() {
        return reminder;
    }

    /**
     * Sets the due reminder attribute of a card.
     *
     * @param reminder defines a input string with reminder to be set.
     */
    private void setReminder(final String reminder) {
        this.reminder = reminder;
    }

    /**
     * Sets the attributes the a due date.
     *
     * @param date defines a input string with the date of the system.
     * @param information defines a input map with the information to be set.
     */
    public void setInformation(final Date date, final Map<String, String> information) {
        HashMap<String, Runnable> cmdList = new HashMap<>();
        cmdList.put("Date", () -> setDate(DateMethod.getDate(date, information.get("Date"))));
        cmdList.put("Reminder", () -> setReminder(information.get("Reminder")));
        information.keySet().forEach(key -> cmdList.get(key).run());
    }
}
