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

package core.selenium.util.datecomponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * HourComponent class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class HourComponent implements IDateComponent {

    @Override
    public String newDate(final int num) {
        DateFormat dateFormat = new SimpleDateFormat("M/d/yyyy h:mm a");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, num);
        return dateFormat.format(calendar.getTime());
    }
}
