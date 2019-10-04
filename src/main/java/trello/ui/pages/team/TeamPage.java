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

package trello.ui.pages.team;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.ApplicationBasePage;

import java.util.List;

/**
 * TeamPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TeamPage extends ApplicationBasePage {

    @FindBy(className = "u-inline")
    private WebElement nameTeamLabel;

    @FindBy(className = "js-org-members")
    private WebElement memberSectionButton;

    @FindBy(css = ".quiet.u-inline-block span")
    private List<WebElement> members;

    /**
     * Waits until nameTeam webElement is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(nameTeamLabel));
    }

    /**
     * Gets the name team from TeamPage.
     *
     * @return as String the name of team.
     */
    public String getNameTeam() {
        return nameTeamLabel.getText();
    }

    /**
     * Opens the section member into the team page.
     */
    public void openMemberSection() {
        memberSectionButton.click();
    }

    /**
     * Gets username of members from team page.
     *
     * @return as list the username of member section.
     */
    public List<String> getUserNameOfMembers() {
        return WebDriverMethod.getTextOfElements(members);
    }
}
