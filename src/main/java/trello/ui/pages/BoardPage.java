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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * BoardPage class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public class BoardPage extends BasePage {

    @FindBy(className = "placeholder")
    private WebElement newListButton;

    @FindBy(className = "list-name-input")
    private WebElement newListNameField;

    @FindBy(className = "primary")
    private WebElement addNewListButton;

    @FindBy(className = "js-close-list")
    private WebElement archiveListButton;

    private static final String BOARD_TITLE_XPATH = "//h2[contains(text(), \"%s\")]";
    private static final String BOARD_MENU_SUFFIX = "/following-sibling::div";

    @FindBy(id = "board")
    private WebElement board;

    @FindBy(css = "div.list")
    private List<WebElement> lists;

    @FindBy(className = "js-card-title")
    private WebElement titleCard;

    @FindBy(className = "js-add-card")
    private WebElement addCard;

    @FindBy(className = "js-add-another-card")
    private WebElement addAnotherCard;

    @FindBy(className = "js-add-a-card")
    private WebElement addACard;

    @FindBy(className = "js-card-details")
    private List<WebElement> cards;

    @FindBy(className = "js-open-add-list")
    private WebElement addAnotherLits;

    /**
     * Creates a new list.
     *
     * @param listTitle is the list name that will be assigned to the list.
     */
    public void createNewList(final String listTitle) {
        newListButton.click();
        WebDriverMethod.setTxtElement(newListNameField, listTitle);
        addNewListButton.click();
    }

    /**
     * Verifies is the list is on the board.
     *
     * @param listTitle is the title of the list that is requested to find.
     * @return true is the list is on the board.
     */
    public boolean isThereThisListByTitle(final String listTitle) {
        String boardTitleXpath = String.format(BOARD_TITLE_XPATH, listTitle);
        WebElement listHeader = driver.findElement(By.xpath(boardTitleXpath));
        return listHeader.getAttribute("textContent").equals(listTitle);
    }

    /**
     * Archives list by list title.
     *
     * @param listTitle is the title of the list that is requested to archive.
     */
    public void archiveListByTitle(final String listTitle) {
        String boardMenuXpath = String.format(BOARD_TITLE_XPATH + BOARD_MENU_SUFFIX, listTitle);
        WebElement listMenuBtn = driver.findElement(By.xpath(boardMenuXpath));
        listMenuBtn.click();
        archiveListButton.click();
    }

    /**
     * Adds a new card to a list.
     *
     * @param listTitle defines the lists where add a card.
     * @param cardTitle defines the card  to be add.
     */
    public void addCardInList(final String listTitle, final String cardTitle) {
        for (WebElement list : lists) {
            if (list.findElement(By.className("js-list-name-input")).getText().equals(listTitle)) {
                if (list.findElement(By.className("js-add-a-card")).isDisplayed()) {
                    list.findElement(By.className("js-add-a-card")).click();
                } else {
                    list.findElement(By.className("js-add-another-card")).click();
                }
                WebDriverMethod.setTxtElement(titleCard, cardTitle);
                addCard.click();
            }
        }
    }

    /**
     * Searches a card in a list.
     *
     * @param listTitle defines of list in that search.
     * @param cardTitle defines the card that search.
     * @return a boolean with value true if card exist in list.
     */
    public boolean searchCardInList(final String listTitle, final String cardTitle) {
        boolean result = false;
        List<WebElement> cards = cardsInList(listTitle);
        for (WebElement card : cards) {
            if (card.findElement(By.className("js-card-name")).getText().equals(cardTitle)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Gets a List with the cards of a list.
     *
     * @param listTitle defines the list that search.
     * @return a List<WebElement>.
     */
    public List<WebElement> cardsInList(final String listTitle) {
        List<WebElement> cardsInList = new ArrayList<WebElement>();
        for (WebElement list : lists) {
            if (list.findElement(By.className("js-list-name-input")).getText().equals(listTitle)) {
                cardsInList = list.findElements(By.className("js-card-details"));
            }
        }
        return cardsInList;
    }

    /**
     * Gets of the name of a card.
     *
     * @param listTitle defines of list in that search.
     * @param cardTitle defines the card that search.
     * @return a string with thr name of a card.
     */
    public String getCardTitle(final String listTitle, final String cardTitle) {
        String title = null;
        List<WebElement> cards = cardsInList(listTitle);
        for (WebElement card : cards) {
            if (card.findElement(By.className("js-card-name")).getText().equals(cardTitle)) {
                title = card.findElement(By.className("js-card-name")).getText();
            }
        }
        return title;
    }

    /**
     * Does click a card to be selected.
     *
     * @param cardTitle defines the card title that search.
     */
    public void selectedCard(final String cardTitle) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardTitle)) {
                cards.get(i).click();
            }
        }
    }

    /**
     * Wait until Page object is found.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(addAnotherLits));
    }
}
