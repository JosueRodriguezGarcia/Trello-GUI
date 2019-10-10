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


import core.selenium.util.datecomponent.DayComponent;
import core.selenium.util.datecomponent.HourComponent;
import core.selenium.util.datecomponent.IDateComponent;
import core.selenium.util.datecomponent.YearComponent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        dateComponent.put("month", new Month());
        dateComponent.put("year", new YearComponent());
    }

    private static Map<String, Integer> hours = new HashMap<>();

    static {
        hours.put("One hour from now", 1);
        hours.put("Two hour from now", 2);
    }

    private static Map<String, Integer> dates = new HashMap<>();

    static {
        hours.put("Today", 0);
        hours.put("Tomorrow", 1);
    }


    /**
     * constructor method request to checkStyle.
     */
    private DateMethod() {

    }

    /**
     * Gets the hour with a hour add.
     *
     * @param date defines a input date.
     * @param addHour defines a input time for add.
     * @return a string with the hour.
     */
    public static String getHour(final Date date, final String addHour) {
        DateFormat hourFormat = new SimpleDateFormat("HH:mm a");
        return getNextHour(hourFormat.format(date), hours.get(addHour));
    }

    /**
     * Gets the date of the system.
     *
     * @param date defines a input date.
     * @param addDay defines a input int with the day to be add.
     * @return a string with the date.
     */
    public static String getDate(final Date date, final String addDay) {
        String[] comand = addDay.split(" ",3);
        int cant = Integer.parseInt(WordsToNumbers.convert(comand[0]));
        String newDate = getNewDate(comand[1],cant);
        System.out.println(comand[0]);
        System.out.println(num);
        System.out.println(comand[1]);
        System.out.println(comand[2]);
        DateFormat hourFormat = new SimpleDateFormat("MM/d/yyyy");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,1);
        return hourFormat.format(date);
    }

    public static String getNewDate(final String date, final int cant){
        return dateComponent.get(date).newDateIncrement(cant);
    }

    /**
     * Gets a next hour.
     *
     * @param hourFormat defines a input string with hour of the system.
     * @param addHour    defines a input int with the hour to be add.
     * @return a string with the next hour.
     */
    private static String getNextHour(final String hourFormat, final int addHour) {
        final int eleven = 11;
        final int twelve = 12;
        String result = "";
        String[] hours = hourFormat.split(":");
        String[] pediodo = hours[1].split(" ");

        String hour = hours[0];
        String minutes = pediodo[0];
        String ampm = pediodo[1];

        int nextHour = isMayor(Integer.parseInt(hour) + addHour);

        if (nextHour >= 1 && nextHour <= eleven) {
            result = nextHour + ":" + hours[1];
        } else {
            if (nextHour == twelve) {
                if (ampm.equals("AM")) {
                    result = nextHour + ":" + minutes + " " + "PM";
                } else {
                    result = nextHour + ":" + minutes + " " + "AM";
                }
            }
        }
        return result;
    }

    /**
     * Verifies that next hour is minor that twelve.
     *
     * @param nextHour defines the hour to be verify.
     * @return a int with the hour.
     */
    private static int isMayor(final int nextHour) {
        final int aux = 12;
        return nextHour > aux ? (nextHour - aux) : nextHour;
    }

    /**
     * Verifies that the next hour have a digit.
     *
     * @param nextHour defines the hour to be verify.
     * @return a string with the hour with two digits.
     */
    private static String addZero(final int nextHour) {
        final int aux = 10;
        return nextHour < aux ? ("0" + nextHour) : String.valueOf(nextHour);
    }

    public String getNewDateWithNewHour(final int cant) {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY,cant);
        return dateFormat.format(calendar.getTime());
    }

    public String getNewDateWithNewDay(final int cant) {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        return dateFormat.format(calendar.getTime());
    }

    public String getNewDateWithNewMonth(final int cant) {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,cant);
        return dateFormat.format(calendar.getTime());
    }

    public String newDateWithNewYear(final int cant) {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy H:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR,cant);
        return dateFormat.format(calendar.getTime());
    }
}
