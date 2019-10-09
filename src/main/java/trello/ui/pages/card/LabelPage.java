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

package trello.ui.pages.card;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * LabelPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class LabelPage extends BasePage {

    @FindBy(css = ".pop-over-header-back-btn")
    private WebElement returnBackLink;

    @FindBy(className = "pop-over-header-title")
    private WebElement titleLabel;

    @FindBy(css = ".js-label-search")
    private WebElement searchLabelField;

    @FindBy(css = ".edit-labels-pop-over.js-labels-list")
    private WebElement resultLabelLink;

    /**
     * Waits until web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }

    /**
     * Adds a Label to Card.
     *
     * @param nameLabel is to search the label.
     * @return an instance of OptionPage class.
     */
    public OptionPage addLabel(final String nameLabel) {
        WebDriverMethod.setTxtElement(searchLabelField, nameLabel);
        resultLabelLink.click();
        returnBackLink.click();
        return new OptionPage();
    }
}
