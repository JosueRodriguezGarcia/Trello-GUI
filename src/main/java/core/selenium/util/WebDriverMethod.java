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

import org.openqa.selenium.WebElement;

/**
 * WebDriverMethod class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class WebDriverMethod {

    /**
     * Sets text in the WebElement object.
     *
     * @param webElement to set its text.
     * @param text is the new value to send in sendKeys parameter.
     */
    public static void setTxtElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }
}
