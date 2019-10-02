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
import trello.ui.pages.BasePage;

/**
 * TeamModalPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TeamModalPage extends BasePage {

    @FindBy(className = "_3Iqnw8HlCKvcSz")
    private WebElement pageTitleLabel;

    @FindBy(className = "_1CLyNodCAa-vQi")
    private WebElement nameField;

    @FindBy(className = "_1aS0LdGertk5P7")
    private WebElement continueButton;

    /**
     * Wait until the title of page is find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(pageTitleLabel));
    }

    /**
     * Creates a team with the name parameter.
     *
     * @param name is required parameter for create a team object.
     */
    public void createTeam(String name) {
        WebDriverMethod.setTxtElement(nameField, name);
        continueButton.click();
    }
}
