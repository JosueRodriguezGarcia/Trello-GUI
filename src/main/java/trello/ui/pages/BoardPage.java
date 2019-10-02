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
import trello.entities.Card;

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

    @FindBy(className = ARCHIVE_LIST_CLASS)
    private WebElement archiveListButton;

    @FindBy(className = "js-move-cards")
    private WebElement moveAllCardsButton;

    @FindBy(className = "js-sort-cards")
    private WebElement sortCardsButton;

    @FindBy(className = SORT_BY_NAME_CLASS)
    private WebElement sortByCardNameButton;

    private static final String ARCHIVE_LIST_CLASS = "js-close-list";
    private static final String SORT_BY_NAME_CLASS = "js-sort-by-card-name";
    private static final String LIST_TITLE_XPATH = "//h2[contains(text(), '%s')]";
    private static final String LIST_MENU_SUFFIX = "/following-sibling::div";
    private static final String LIST_MENU_XPATH = LIST_TITLE_XPATH + LIST_MENU_SUFFIX;
    private static final String TARGET_LIST_TITLE_XPATH = "//a[contains(text(), '%s')]";
    private static final String LIST_NUMBER_CARDS_SUFFIX = "/following-sibling::p";
    private static final String LIST_NUMBER_CARDS = LIST_TITLE_XPATH + LIST_NUMBER_CARDS_SUFFIX;
    private static final String NEXT_CARD_SUFFIX = "/../following-sibling::div/a";
    private static final String NEXT_CARD_XPATH = LIST_TITLE_XPATH + NEXT_CARD_SUFFIX;

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
        String listTitleXpath = String.format(LIST_TITLE_XPATH, listTitle);
        WebElement listHeader = driver.findElement(By.xpath(listTitleXpath));
        return listHeader.getAttribute("textContent").equals(listTitle);
    }

    /**
     * Archives list by list title.
     * @param listTitle is the title of the list that is requested to archive.
     */
    public void archiveListByTitle(final String listTitle) {
        dropdownListMenu(listTitle);
        archiveListButton.click();
    }

    private void dropdownListMenu(final String listTitle) {
        String listMenuXpath = String.format(LIST_MENU_XPATH, listTitle);
        WebElement listMenuBtn = driver.findElement(By.xpath(listMenuXpath));
        listMenuBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(ARCHIVE_LIST_CLASS)));
    }

    /**
     * Wait until Page object is found.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }

    public void moveAllCards(final String listFrom, final String listTarget) {
        getCardsInList(listFrom);
        dropdownListMenu(listFrom);
        moveAllCardsButton.click();
        String targetListButtonXpath = String.format(TARGET_LIST_TITLE_XPATH, listTarget);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(targetListButtonXpath)));
        WebElement targetListButton = driver.findElement(By.xpath(targetListButtonXpath));
        targetListButton.click();
    }

    public ArrayList<Card> getCardsInList(final String listFrom) {
        ArrayList<Card> cardsInList = new ArrayList<>();

        List<WebElement> elementsInList = driver.findElements(By.xpath(String.format(NEXT_CARD_XPATH, listFrom)));

        for (int index = 0; index < elementsInList.size(); index++) {
            Card cardInIndex = new Card();
            //in progress... joshua is working on it.
            cardsInList.add(cardInIndex);
        }
        return null;
    }

    public void sortCardsInListByName(final String listTitle) {
        //getCardsInList
        dropdownListMenu(listTitle);
        sortCardsButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(SORT_BY_NAME_CLASS)));
        sortByCardNameButton.click();
    }
}
