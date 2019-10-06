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

package trello.ui.pages.board;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * ListForm class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class ListForm extends BasePage {

    @FindBy(className = "js-save-edit")
    private WebElement addListButton;

    @FindBy(className = "js-cancel-edit")
    private WebElement closeFormLink;

    /**
     * Wait until web element is visible in list form.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(addListButton));
    }

    /**
     * Closes the list form.
     */
    public void closeListForm() {
        WebDriverMethod.clickButton(driver, closeFormLink);
    }
}
