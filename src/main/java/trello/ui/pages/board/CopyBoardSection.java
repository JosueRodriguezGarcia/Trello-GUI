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

package trello.ui.pages.board;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * CopyBoardSection class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class CopyBoardSection extends BasePage {

    private static final String OPTION_TEAM_XPATH = "//option[contains(text(), '%s')]";

    @FindBy(css = ".primary.wide.js-submit")
    private WebElement submitButton;

    @FindBy(id = "boardNewTitle")
    private WebElement titleBoardField;

    @FindBy(name = "org-id")
    private WebElement listTeamCheckList;

    /**
     * Waits until the web element is clickable.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
    }

    /**
     * Copy board to team in the Copy Boar section.
     *
     * @param titleBoard is to set the name the board;
     * @param nameTeam is to select the name of team.
     * @return an instance of TopMenuContent class.
     */
    public TopMenuBoardContent copyBoard(final String titleBoard, final String nameTeam) {
        WebDriverMethod.setTxtElement(titleBoardField, titleBoard);
        String teamToSelect = String.format(OPTION_TEAM_XPATH, nameTeam);
        WebDriverMethod.selectCheckList(driver, "xpath", teamToSelect);
        submitButton.click();
        return new TopMenuBoardContent();
    }
}
