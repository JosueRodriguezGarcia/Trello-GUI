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
import org.checkerframework.checker.units.qual.C;
import trello.entities.Context;
import trello.entities.List;
import trello.ui.pages.BoardPage;

/**
 * ListHooks class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public class ListHooks {

    private Context context;
    private BoardPage boardPage;

    public ListHooks(Context context) {
        this.context = context;
    }

    @After("@ArchiveList")
    public void archiveList() {
        boardPage = new BoardPage();
        boardPage.removeList(context.getList().getTitle());
    }
}
