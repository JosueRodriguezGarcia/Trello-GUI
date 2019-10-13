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
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Method;
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

    @FindBy(xpath = "//span[@class='icon-lg icon-clock']/../..//following-sibling::ul//a")
    private List<WebElement> boardInRecentlyViewedLink;

    @FindBy(xpath = "//span[@class='icon-lg icon-member']/../..//following-sibling::ul//a")
    private List<WebElement> boardInPersonalBoardLink;

    @FindBy(css = "div.board-tile.mod-add")
    private WebElement createBoardLabel;

    private static final String BOARDS_TO_TEAM_XPATH= "//h3[contains(text(), '%s')]/../..//following-sibling::ul//a";
    private static final String TEAM_SECTION_LINK_PATH = "//h3[contains(text(), '%s')]";


    /**
     * Wait until web element is visible.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(boardLink));
    }

    /**
     * Gets the Boards sections from HomeContentFrame class.
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
     * Adds boar section to a Map.
     *
     * @param nameSection is to set the key of Map.
     * @param listBoard is to set the value of Map.
     */
    private void addBoardSections(final String nameSection, final List<WebElement> listBoard) {
        getBoarSections().put(nameSection, listBoard);
    }

    /**
     * Opens the Board modal page make a click in the "Create new board" label.
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
//        boolean result = false;
//        List<WebElement> boardsLink = getBoarSections().get(nameSection.toLowerCase());
//        for (WebElement element : boardsLink) {
//            if (element.getText().compareTo(nameBoard) == 0) {
//                result = true;
//                break;
//            }
//        }
//        return result;
        List<WebElement> boardsLink = getBoarSections().get(nameSection.toLowerCase());

        return  boardsLink == null ? existBoarIntoTeam(nameBoard, nameSection)
                :isInList(nameBoard, boardsLink);
    }

    private boolean existBoarIntoTeam(final String nameBoard, final String nameTeam) {
        String teamLocator = String.format(TEAM_SECTION_LINK_PATH, nameTeam);
        WebElement teamSectionLink = driver.findElement(By.xpath(teamLocator));
        WebDriverMethod.waitUntilFindElement(driver, teamSectionLink);
        String locator = String.format(BOARDS_TO_TEAM_XPATH, nameTeam);
        List<WebElement> boardsLink = driver.findElements(By.xpath(locator));
        return isInList(nameBoard, boardsLink);
    }

    private boolean isInList(final String nameBoard, final List<WebElement> webElements) {
        boolean result = false;
        for (WebElement element : webElements) {
            if (element.getText().compareTo(nameBoard) == 0) {
                result = true;
                break;
            }
        }
        return result;
    }
}
