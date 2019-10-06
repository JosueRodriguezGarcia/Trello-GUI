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

package trello.ui.pages;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * HomeContentFrame class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class HomeContentFrame extends BasePage {

    @FindBy(css = "a._1hc34_9rc6xcjf.AqhrxyGOPcyvoq")
    private WebElement boardLink;

    @FindBy(xpath = "//span[@class='icon-lg icon-clock']//ancestor::div[@class='boards-page-board-section-header']//following-sibling::ul//li//a")
    private List<WebElement> boardInRecentlyViewedLink;

    @FindBy(xpath = "//span[@class='icon-lg icon-member']//ancestor::div[@class='boards-page-board-section-header']//following-sibling::ul//li//a")
    private List<WebElement> boardInPersonalBoardLink;

    @FindBy(css = "div.board-tile.mod-add")
    private WebElement createBoardLabel;

    /**
     * Wait until web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(boardLink));
    }

    /**
     * gets the Boards sections from HomeContentFrame class.
     *
     * @return a Map with name sections and web elements list.
     */
    private Map<String, List<WebElement>> getBoarSections() {
        Map<String, List<WebElement>> boardSection = new HashMap<>();
        boardSection.put("recently viewed", boardInRecentlyViewedLink);
        boardSection.put("personal boards", boardInPersonalBoardLink);
        return boardSection;
    }
    /**
     * Open the Board modal page make a click in the "Create new board" label.
     */
    public void openBoardModal() {
        WebDriverMethod.clickButton(driver, createBoardLabel);
    }

    /**
     * Verifies if the name of board exist in the section.
     *
     * @param nameBoard is to find the board.
     * @param nameSection is to select the section.
     * @return true if the name of board exist in this section.
     */
    public boolean existBoardInSection(final String nameBoard, final String nameSection) {
        boolean result = false;
        List<WebElement> boardsLink = getBoarSections().get(nameSection.toLowerCase());

        for (WebElement element : boardsLink) {
            if (element.getText().compareTo(nameBoard) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }
}
