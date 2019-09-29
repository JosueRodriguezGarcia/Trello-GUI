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

/**
 * ListHooks class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */
public class ListHooks {

    private Context context;
    private BoardPage boardPage;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public ListHooks(final Context currentContext) {
        this.context = currentContext;
    }

    /**
     * Archives the context's list.
     */
    @After("@ArchiveList")
    public void archiveList() {
        boardPage = new BoardPage();
        boardPage.archiveListByTitle(context.getList().getTitle());
    }
}
