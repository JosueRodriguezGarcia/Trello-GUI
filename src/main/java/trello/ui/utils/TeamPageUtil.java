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

package trello.ui.utils;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * TeamPageUtil class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public final class TeamPageUtil {

    /**
     * Private constructor requested by checkstyle.
     */
    private TeamPageUtil() {
    }

    /**
     * Gets username of members of member's section from TeamPage.
     *
     * @param webElements is to get username their text.
     * @return as List all username from WebElement list.
     */
    public static List<String> getUsernameOfMembers(final List<WebElement> webElements) {
        List<String> result = new ArrayList<String>();
        for (WebElement webElement : webElements) {
            String textElement = (webElement.getText().replaceAll("@", ""));
            result.add(textElement);
        }
        return result;
    }
}
