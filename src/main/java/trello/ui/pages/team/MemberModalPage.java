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

package trello.ui.pages.team;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import trello.ui.pages.BasePage;

import java.util.List;

/**
 * MemberModalPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class MemberModalPage extends BasePage {

    @FindBy(className = "_2-T1xH-fhIz60N")
    private WebElement pageTileLabel;

    @FindBy(className = "autocomplete-input")
    private WebElement memberField;

    @FindBy(className = "member")
    private WebElement availableMemberLabel;

    @FindBy(css = ".autocomplete-btn.primary.fullWidthButton")
    private WebElement inviteTeamButton;

    /**
     * Waits until the title is visible in this page.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTileLabel));
    }

    /**
     * Adds several members at team.
     *
     * @param members is all members to add a team.
     */
    public void addMember(List<String> members) {
        for (String member : members
             ) {
            memberField.sendKeys(member);
            checkMember();
        }
        inviteTeamButton.click();
    }

    /**
     * Checks the member that find.
     */
    private void checkMember() {
        WebDriverMethod.waitElementBeClickable(driver, availableMemberLabel);
        availableMemberLabel.click();
    }
}
