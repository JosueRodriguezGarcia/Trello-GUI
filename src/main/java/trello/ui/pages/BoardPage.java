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

import core.selenium.WebDriverConfig;
import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import trello.entities.Card;

import trello.ui.pages.modal.CardModal;
import trello.ui.pages.modal.InviteToBoardModal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * BoardPage class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public class BoardPage extends ApplicationBasePage {

    private static final String ARCHIVE_LIST_CLASS = "js-close-list";
    private static final String TARGET_LIST_CLASS = "js-select-list";
    private static final String CREATE_CARD_CLASS = "js-submit";
    private static final String SORT_BY_NAME_CLASS = "js-sort-by-card-name";
    private static final String SORT_BY_OLDEST_FIRST_CLASS = "js-sort-oldest-first";
    private static final String LIST_TITLE_XPATH = "//h2[contains(text(), '%s')]";
    private static final String LIST_MENU_SUFFIX = "/following-sibling::div";
    private static final String LIST_MENU_XPATH = LIST_TITLE_XPATH + LIST_MENU_SUFFIX;
    private static final String CARDS_FROM_LIST_SUFFIX = "/../following-sibling::div";
    private static final String CARDS_IN_LIST_XPATH = LIST_TITLE_XPATH + CARDS_FROM_LIST_SUFFIX;
    private static final String TARGET_LIST_TITLE_XPATH = "//a[contains(text(), '%s')]";
    private static final String ARCHIVE_CARD_QUICK_MENU_CSS = ".js-archive > .quick-card-editor-buttons-item-text";
    private static final String COPY_CARD_QUICK_MENU_CSS = ".js-copy-card > .quick-card-editor-buttons-item-text";
    private static final String CARD_PARENT_XPATH = "//span[contains(text(), '%s')]/../../../..";

    @FindBy(className = "js-board-editing-target")
    private WebElement nameBoardButton;

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

    @FindBy(className = SORT_BY_OLDEST_FIRST_CLASS)
    private WebElement sortByOldestFirstButton;

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
    private WebElement addAnotherList;

    @FindBy(className = "js-open-manage-board-members")
    private WebElement inviteButton;

    private By listHeader = By.cssSelector("textarea[class*='header-name']");

    /**
     * Waits until Page object is found.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(addAnotherList));
    }

    /**
     * Gets the name of Board into BoardPage.
     *
     * @return as string the name of Board.
     */
    public String getNameBoardButton() {
        return nameBoardButton.getText();
    }

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
     *
     * @param listTitle is the title of the list that is requested to archive.
     */
    public void archiveListByTitle(final String listTitle) {
        dropdownListMenu(listTitle);
        try {
            archiveListButton.click();
        } catch (StaleElementReferenceException sere) {
            archiveListButton.click();
        }
    }

    /**
     * Drops down the list's menu.
     *
     * @param listTitle is the title of the list which menu is wanted to be dropped down.
     */
    private void dropdownListMenu(final String listTitle) {
        String listMenuXpath = String.format(LIST_MENU_XPATH, listTitle);
        WebElement listMenuBtn = driver.findElement(By.xpath(listMenuXpath));
        listMenuBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(ARCHIVE_LIST_CLASS)));
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
        String cardName;
        boolean result = false;
        List<WebElement> cards = cardsInList(listTitle);
        for (WebElement card : cards) {
            try {
                cardName = card.findElement(By.className("js-card-name")).getText();
            } catch (StaleElementReferenceException sere) {
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className("js-card-name")));
                cardName = card.findElement(By.className("js-card-name")).getText();
            }
            if (cardName.equals(cardTitle)) {
                result = true;
                break;
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
     * @return a instance of cardModal class.
     */
    public CardModal selectedCard(final String cardTitle) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardTitle)) {
                cards.get(i).click();
            }
        }
        return new CardModal();
    }

    /**
     * Moves all cards in given list to given target list.
     *
     * @param listFrom   is the list which the cards will be moved from.
     * @param listTarget is the target list where the cards will be moved to.
     */
    public void moveAllCards(final String listFrom, final String listTarget) {
        dropdownListMenu(listFrom);
        moveAllCardsButton.click();
        String targetListButtonXpath = String.format(TARGET_LIST_TITLE_XPATH, listTarget);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(targetListButtonXpath)));
        WebElement targetListButton = driver.findElement(By.xpath(targetListButtonXpath));
        targetListButton.click();
    }

    /**
     * Gets all cards in list.
     *
     * @param listTitle is the title of the list which cards are required to retrieve.
     * @return a List of al cards in the list.
     */
    public List<Card> getCardsInList(final String listTitle) {
        List<Card> cardsInList = new ArrayList<>();
        List<WebElement> cards = cardsInList(listTitle);
        for (WebElement card : cards) {
            Card cardInIndex = new Card();
            try {
                cardInIndex.setTitle(card.findElement(By.className("js-card-name")).getText());
            } catch (StaleElementReferenceException sere) {
                cardInIndex.setTitle(card.findElement(By.className("js-card-name")).getText());
            }
            cardsInList.add(cardInIndex);
        }
        return cardsInList;
    }

    /**
     * Gets the quantity of cards that are in the list.
     *
     * @param listTitle is the title of the list which quantity of cards are required.
     * @return the quantity on cards in the list.
     */
    public int getQttyCardsInList(final String listTitle) {
        final long time = 1;
        int cardsQty;
        driver.
                manage().
                timeouts().
                implicitlyWait(time, TimeUnit.SECONDS);
        cardsQty = cardsInList(listTitle).size();
        driver.
                manage().
                timeouts().
                implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        return cardsQty;
    }

    /**
     * Sorts cards in list by card name.
     *
     * @param listTitle is the title of the list which is wanted to be sorted.
     */
    public void sortCardsInListByName(final String listTitle) {
        dropdownListMenu(listTitle);
        sortCardsButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(SORT_BY_NAME_CLASS)));
        sortByCardNameButton.click();
    }

    /**
     * Sorts cards in list by oldest first.
     *
     * @param listTitle is the title of the list which is wanted to be sorted.
     */
    public void sortCardsInListByOldestFirst(final String listTitle) {
        dropdownListMenu(listTitle);
        sortCardsButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(SORT_BY_OLDEST_FIRST_CLASS)));
        sortByOldestFirstButton.click();
    }

    /**
     * Copies a card to another list.
     *
     * @param cardTitle  is the title of the card to be copied.
     * @param sourceList is the list where the card is.
     * @param targetList is the list where is required the card to be copied to.
     */
    public void copyCardToList(final String cardTitle, final String sourceList, final String targetList) {
        showQuickCardMenu(cardTitle, sourceList);
        WebElement copyCardButton = driver.findElement(By.cssSelector(COPY_CARD_QUICK_MENU_CSS));
        copyCardButton.click();
        WebElement targetListDropDown = driver.findElement(By.className(TARGET_LIST_CLASS));
        String optionXpath = String.format("//option[. = '%s']", targetList);
        targetListDropDown.findElement(By.xpath(optionXpath)).click();
        WebElement createCardButton = driver.findElement(By.className(CREATE_CARD_CLASS));
        createCardButton.click();
    }

    /**
     * Verifies is there is given card title in the given list. This method is used as workaround due to
     * searchCardInList method is not working for the scenario copy a card. It throws a StaleElementReferenceException
     * even though there is a try/catch that retries finding the required web element.
     *
     * @param cardTitle is the title of the card that is wanted to verify the presence.
     * @param listTitle is the title of the list where is wanted to verify the card presence.
     * @return true if the card is in the list.
     */
    public boolean isCardInList(final String cardTitle, final String listTitle) {
        WebElement cardsInList = driver.findElement(By.xpath(String.format(CARDS_IN_LIST_XPATH, listTitle)));
        WebElement foundCard = cardsInList.findElement(By.cssSelector(String.format("a[href*='%s']",
                cardTitle.toLowerCase())));
        return foundCard.getText().equals(cardTitle);
    }

    /**
     * Shows the quick card menu.
     *
     * @param cardTitle is the title of the card which the quick menu is required.
     * @param listTitle is the title of the list where the card is.
     */
    public void showQuickCardMenu(final String cardTitle, final String listTitle) {
        WebElement cardsInList = driver.findElement(By.xpath(String.format(CARDS_IN_LIST_XPATH, listTitle)));
        WebElement foundCard = cardsInList.findElement(By.cssSelector(String.format("a[href*='%s']",
                cardTitle.toLowerCase())));
        Actions actions = new Actions(driver);
        actions.contextClick(foundCard).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ARCHIVE_CARD_QUICK_MENU_CSS)));
    }

    /**
     * Deletes given card according to its list and title.
     *
     * @param cardTitle is the title of the card to be deleted.
     * @param listTitle is the title of the list where the card is.
     */
    public void deleteCardInList(final String cardTitle, final String listTitle) {
        showQuickCardMenu(cardTitle, listTitle);
        WebElement archiveButton = driver.findElement(By.cssSelector(ARCHIVE_CARD_QUICK_MENU_CSS));
        archiveButton.click();
    }

    /**
     * Gets the list where the card is.
     * It is recommendable to use this method just for cards that that are not duplicated.
     *
     * @param cardTitle is the title of the card whick the list where it belongs is required.
     * @return the list where is the card.
     */
    public String getListWhereCardIs(final String cardTitle) {
        WebElement cardParent = driver.findElement(By.xpath(String.format(CARD_PARENT_XPATH, cardTitle)));
        WebElement cardListHeader = cardParent.findElement(listHeader);
        return cardListHeader.getText();
    }

    /**
     * Gets the id Board from BoardPage.
     *
     * @return as string the id of Board.
     */
    public String getId() {
        String uri = driver.getCurrentUrl();
        return uri.substring(uri.lastIndexOf("b/") + 2, uri.lastIndexOf('/'));
    }

    /**
     * Does click in invite button.
     *
     * @return a InviteToBoardModal.
     */
    public InviteToBoardModal clickInviteButton() {
        inviteButton.click();
        return new InviteToBoardModal();
    }

    /**
     * Selects a card in a list.
     *
     * @param cardTitle is the title of the card which the quick menu is required.
     * @param listTitle is the title of the list where the card is.
     * @return a instance of card Modal.
     */
    public CardModal selectInCardInList(final String listTitle, final String cardTitle) {
        WebElement cardsInList = driver.findElement(By.xpath(String.format(CARDS_IN_LIST_XPATH, listTitle)));
        WebElement foundCard = cardsInList.findElement(By.cssSelector(String.format("a[href*='%s']",
                cardTitle.toLowerCase())));
        foundCard.click();
        return new CardModal();
    }
}
