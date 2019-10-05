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

package trello.ui.pages;

import trello.ui.components.TopMenu;

/**
 * ApplicationBasePage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public abstract class ApplicationBasePage extends BasePage {

    private TopMenu topMenu;

    /**
     * Constructor method to create an object of this class.
     */
    protected ApplicationBasePage() {
        this.topMenu = new TopMenu();
    }

    /**
     * Gets the topMenu attribute of this class.
     *
     * @return the topMenu attribute of it's class.
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }

    protected void waitUntilPageObjectIsLoaded() {

    }
}
