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

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * HomePage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class HomePage extends BasePage {

    @FindBy(className = "_1q-xxtNvcdFBca")
    private WebElement trelloLogoTxt;

    @FindBy(className = "_24AWINHReYjNBf")
    private WebElement initialFullNameUserBtton;

    /**
     * Wait until Page object was find for.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(trelloLogoTxt));
    }

    /**
     * Gets the initial full name of HomePage class.
     *
     * @return as string the initial of full name.
     */
    public String getInitialFullName() {
        return initialFullNameUserBtton.getText();
    }
}
