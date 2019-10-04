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

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * HomePage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class HomePage extends ApplicationBasePage {

    @FindBy(className = INITIAL_CLASS_NAME)
    private WebElement fullNameInitialsButton;

    @FindBy(css = "[data-test-id='home-team-tab-name']")
    private List<WebElement> teamNameLink;

    private static final String INITIAL_CLASS_NAME = "_24AWINHReYjNBf";
    private static final String CSS_TO_BOARD = "div[title=\"%s\"]";

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        WebDriverMethod.waitForATextInWebElement(wait, "className", INITIAL_CLASS_NAME);
    }

    /**
     * Gets the initial full name of HomePage class.
     *
     * @return as string the initial of full name.
     */
    public String getFullNameInitials() {
        WebDriverMethod.waitElementBeClickable(driver, fullNameInitialsButton);
        return fullNameInitialsButton.getText();
    }

    /**
     * Goes to the board page.
     *
     * @param boardTitle is the title of the board.
     */
    public void clickOnABoard(final String boardTitle) {
        String boardCss = String.format(CSS_TO_BOARD, boardTitle);
        WebElement boardButton = driver.findElement(By.cssSelector(boardCss));
        boardButton.click();
    }

    /**
     * Verify if exist the name of team in HomePage.
     *
     * @param nameTeam is to search the name of team.
     * @return true if the name of team exit.
     */
    public boolean existNameOfTeam(final String nameTeam) {
        boolean exist = false;
        for (WebElement element : teamNameLink) {
            if (element.getText().compareTo(nameTeam) == 0) {
                exist = true;
                break;
            }
        }
        return exist;
    }
}
