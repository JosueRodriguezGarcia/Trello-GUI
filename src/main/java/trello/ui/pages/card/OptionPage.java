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

package trello.ui.pages.card;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

/**
 * OptionPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class OptionPage extends BasePage {

    @FindBy(className = "pop-over-header-title")
    private WebElement titleLabel;

    @FindBy(css = ".pop-over-header-close-btn")
    private WebElement closeLink;

    @FindBy(className = "js-mem-selector")
    private WebElement memberTitleLabel;

    @FindBy(className = "js-label-selector")
    private WebElement labelTitleLabel;


    /**
     * Waits until the web element is find.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titleLabel));
    }

    /**
     * Opens the MemberPage from OptionPage.
     *
     * @return an instance of MemberPage.
     */
    public MemberPage openMemberPage() {
        memberTitleLabel.click();
        return new MemberPage();
    }

    /**
     * Opens the LabelPage from OptionPage.
     *
     * @return an instance of labelPage class.
     */
    public LabelPage openLabelPage() {
        labelTitleLabel.click();
        return new LabelPage();
    }

    /**
     * Closes this Page.
     */
    public void closePage() {
        closeLink.click();
    }
}
