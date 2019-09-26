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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;

/**
 * HomePage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class HomePage extends BasePage {

    @FindBy(className = INITIAL_NAME_CLASS)
    private WebElement initialFullNameUserBtton;

    private static final String INITIAL_NAME_CLASS = "_24AWINHReYjNBf";
    private static final String CSS_TO_BOARD = "div[title=\"%s\"]";

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        //wait until the webElement has text.
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(final WebDriver driver) {
                return driver.findElement(By.className(INITIAL_NAME_CLASS)).getText().length() != 0;
            }
        });
    }

    /**
     * Gets the initial full name of HomePage class.
     *
     * @return as string the initial of full name.
     */
    public String getInitialFullName() {
        WebDriverMethod.findElementBeClickable(driver, initialFullNameUserBtton);
        return initialFullNameUserBtton.getText();
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
}
