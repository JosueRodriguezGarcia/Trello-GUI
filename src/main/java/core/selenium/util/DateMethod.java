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

import core.selenium.util.datecomponents.DayComponent;
import core.selenium.util.datecomponents.HourComponent;
import core.selenium.util.datecomponents.IDateComponent;
import core.selenium.util.datecomponents.MonthComponent;
import core.selenium.util.datecomponents.YearComponent;

import java.util.HashMap;
import java.util.Map;

/**
 * DateMethod class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public final class DateMethod {

    private static Map<String, IDateComponent> dateComponent = new HashMap<>();

    static {
        dateComponent.put("hour", new HourComponent());
        dateComponent.put("day", new DayComponent());
        dateComponent.put("month", new MonthComponent());
        dateComponent.put("year", new YearComponent());
    }

    /**
     * constructor method request to checkStyle.
     */
    private DateMethod() {

    }

    /**
     * Gets only date.
     *
     * @param date defines a input full date.
     * @return a string with only date.
     */
    public static String getOnlyDate(final String date) {
        String[] aux = date.split(" ", 2);
        return aux[0];
    }

    /**
     * Gets only time.
     *
     * @param date defines a input full date.
     * @return a string with only time.
     */
    public static String getOnlyTime(final String date) {
        String[] aux = date.split(" ", 2);
        return aux[1];
    }

    /**
     * Gets a date request.
     *
     * @param date defines a input full date.
     * @return a string with the date request.
     */
    public static String getDate(final String date) {
        final int numberOfsection = 3;
        String[] comand = date.split(" ", numberOfsection);
        int cant = Integer.parseInt(WordsToNumbers.convert(comand[0]));
        String newDate = getNewDate(cant, comand[1], comand[2]);
        return newDate;
    }

    /**
     * Get the date according of information the sentence.
     *
     * @param cant      define a input numbers.
     * @param component defines a input date component.
     * @param time      defines a input time pass or future.
     * @return a string with a new date.
     */
    private static String getNewDate(final int cant, final String component, final String time) {
        int num = getNewCant(cant, time);
        return dateComponent.get(component).newDate(num);
    }

    /**
     * Gets a quantity positive or negative.
     *
     * @param cant defines a input with the quantity.
     * @param time defines a input time pass or future.
     * @return a integer.
     */
    private static int getNewCant(final int cant, final String time) {
        return time.equals("from now") ? cant : -cant;
    }
}
