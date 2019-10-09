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
 * MemberPage class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class MemberPage extends BasePage {

    @FindBy(css = ".pop-over-header-back-btn")
    private WebElement returnBackLink;

    @FindBy(className = "pop-over-header-title")
    private WebElement titlePage;

    @FindBy(css = ".js-search-mem.js-autofocus")
    private WebElement searchField;

    @FindBy(css = ".name.js-select-member ")
    private WebElement memberResultLink;

    /**
     * Waits until the web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(titlePage));
    }

    /**
     * Adds a new Member to Card.
     *
     * @param nameMember is to search a member.
     * @return an instance of OptionPage class.
     */
    public OptionPage addMember(final String nameMember) {
        WebDriverMethod.setTxtElement(searchField, nameMember);
        memberResultLink.click();
        returnBackLink.click();
        return new OptionPage();
    }
}
