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

package trello.ui.components;

import org.openqa.selenium.WebElement;

/**
 * Link class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Link implements Element {

    private WebElement element;

    /**
     * Constructor for create object of this class.
     *
     * @param element is to initialize the attribute element of this class.
     */
    public Link(final WebElement element) {
        this.element = element;
    }

    /**
     * Open the page selected with this class.
     */
    @Override
    public void openPage() {
        element.click();
    }
}
