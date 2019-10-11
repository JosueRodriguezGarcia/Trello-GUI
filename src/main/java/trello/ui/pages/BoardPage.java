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
import trello.ui.pages.card.LabelPage;
import trello.ui.pages.card.MemberPage;
import trello.ui.pages.card.OptionPage;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static trello.keys.CardKeys.*;

/**
 * BoardPage class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public class BoardPage extends BasePage {

    private static final String ARCHIVE_LIST_CLASS = "js-close-list";
    private static final String TARGET_LIST_CLASS = "js-select-list";
    private static final String CREATE_CARD_CLASS = "js-submit";
    private static final String SORT_BY_NAME_CLASS = "js-sort-by-card-name";
    private static final String SORT_BY_OLDEST_FIRST_CLASS = "js-sort-oldest-first";
    private static final String LIST_TITLE_XPATH = "//h2[contains(text(), '%s')]";
    private static final String LIST_MENU_SUFFIX = "/following-sibling::div";
    private static final String LIST_MENU_XPATH = LIST_TITLE_XPATH + LIST_MENU_SUFFIX;
    private static final String TARGET_LIST_TITLE_XPATH = "//a[contains(text(), '%s')]";
    private static final String CARD_XPATH = "//span[contains(text(), '%s')]";
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

    @FindBy(css = ".cc-controls-section.mod-right")
    private WebElement optionsLink;

    @FindBy(className = "js-open-add-list")
    private WebElement addAnotherList;

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
     * Adds a new card to a list.
     *
     * @param listTitle defines the lists where add a card.
     * @param card defines the card  to be add.
     */
    public void addCardInList(final String listTitle, final Card card, final Set<String> keysCard) {
        for (WebElement list : lists) {
            System.out.println(listTitle + " into for  ###########################");
            if (list.findElement(By.className("js-list-name-input")).getText().equals(listTitle)) {
                System.out.println("into list  ########################");
                if (list.findElement(By.className("js-add-a-card")).isDisplayed()) {
                    list.findElement(By.className("js-add-a-card")).click();
                } else {
                    list.findElement(By.className("js-add-another-card")).click();
                }
                HashMap<String, Runnable> runnableHashMap = getRunnableMap(card);
                keysCard.forEach(key -> runnableHashMap.get(key).run());
                addCard.click();
            }
        }
    }

    /**
     * Gets the runnable Map with the cardData parameter.
     *
     * @param card is to get data of card.
     * @return an instance HashMap with keys and methods to run.
     */
    private HashMap<String, Runnable> getRunnableMap(final Card card) {
        HashMap<java.lang.String, Runnable> runnableHashMap = new HashMap<>();
        runnableHashMap.put(TITLE,  () -> setTitleCard(card.getTitle()));
        runnableHashMap.put(MEMBER, () -> setMembersToCard(card.getMembers()));
        runnableHashMap.put(LABELS, () -> setLabelToCard(card.getLabels()));
        return runnableHashMap;
    }

    /**
     * Sets the title of Card to create a new Card.
     *
     * @param titleCard is to get the title of card.
     */
    private void setTitleCard(final String titleCard) {
        WebDriverMethod.setTxtElement(this.titleCard, titleCard);
    }

    /**
     * Sets the Member to create a new Card.
     *
     * @param nameMember is to gets the nameMember to create a Card.
     */
    private void setMembersToCard(final String nameMember) {
        OptionPage optionPage = openOptionPage();
        MemberPage memberPage = optionPage.openMemberPage();
        OptionPage anotherOptionPage = memberPage.addMember(nameMember);
        anotherOptionPage.closePage();
    }

    /**
     * Sets the labels to create a new Card.
     *
     * @param nameLabels is to get the nameLabel from list to create a Card.
     */
    private void setLabelToCard(final List<String> nameLabels) {
        for (final String nameLabel : nameLabels) {
            OptionPage optionPage = openOptionPage();
            LabelPage labelPage = optionPage.openLabelPage();
            OptionPage anotherOptionPage = labelPage.addLabel(nameLabel);
            anotherOptionPage.closePage();
        }
    }

    /**
     * Opens the OptionPage to create a Card.
     *
     * @return an instance of OptionPage class before to create a Card.
     */
    private OptionPage openOptionPage() {
        optionsLink.click();
        return new OptionPage();
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
    public void selectCard(final String cardTitle) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getText().equals(cardTitle)) {
                cards.get(i).click();
            }
        }
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
     * @param targetList is the list where is required the card to be copied to.
     */
    public void copyCardToList(final String cardTitle, final String targetList) {
        showQuickCardMenu(cardTitle);
        WebElement copyCardButton = driver.findElement(By.cssSelector(COPY_CARD_QUICK_MENU_CSS));
        copyCardButton.click();
        WebElement targetListDropDown = driver.findElement(By.className(TARGET_LIST_CLASS));
        String optionXpath = String.format("//option[. = '%s']", targetList);
        targetListDropDown.findElement(By.xpath(optionXpath)).click();
        WebElement createCardButton = driver.findElement(By.className(CREATE_CARD_CLASS));
        createCardButton.click();
    }

    /**
     * Shows the quick card menu.
     *
     * @param cardTitle is the title of the card which the quick menu is required.
     */
    public void showQuickCardMenu(final String cardTitle) {
        WebElement card = driver.findElement(By.xpath(String.format(CARD_XPATH, cardTitle)));
        Actions actions = new Actions(driver);
        actions.contextClick(card).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ARCHIVE_CARD_QUICK_MENU_CSS)));
    }

    /**
     * Gets the list where the card is.
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
}
