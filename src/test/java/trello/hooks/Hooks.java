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

package trello.hooks;

import cucumber.api.java.After;
import trello.entities.Context;
import trello.ui.pages.BoardPage;
import trello.ui.pages.LoggedOutPage;

/**
 * Hooks class.
 *
 * @author Raul Choque, Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class Hooks {

    private Context context;
    private BoardPage boardPage;
    private LoggedOutPage loggedOutPage;

    /**
     * LogOut.
     */
    @After
    public void logOut() {
        boardPage = new BoardPage();
        loggedOutPage = boardPage.getTopMenu().logoutPage();
    }
}
