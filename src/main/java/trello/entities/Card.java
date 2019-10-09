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

package trello.entities;

import core.utils.IRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static trello.keys.CardKeys.LABELS;
import static trello.keys.CardKeys.MEMBER;
import static trello.keys.CardKeys.TITLE;

/**
 * Card class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class Card {

    private String id;
    private List<String> idChecklists;
    private String members;
    private List<String> labels;
    private String title;
    private Set<String> cardKeys = new HashSet<String>();

    /**
     * Constructor of this class.
     */
    public Card() {
        labels = new ArrayList();
    }

    /**
     * Sets all values send into cardData parameter.
     *
     * @param cardData is the card data into Map.
     */
    public void addDataToCard(Map<java.lang.String, java.lang.String> cardData) {
        HashMap<java.lang.String, IRunnable> runnableMap = getRunnableMap(cardData);
        runnableMap.keySet().forEach(key -> runnableMap.get(key).runMethod());
    }

    /**
     * Gets the runnable Map with the cardData parameter.
     *
     * @param cardData is to get data of card.
     * @return an instance HashMap with keys and methods to run.
     */
    private HashMap<java.lang.String, IRunnable> getRunnableMap(Map<java.lang.String, java.lang.String> cardData) {
        HashMap<java.lang.String, IRunnable> runnableHashMap = new HashMap<>();
        runnableHashMap.put(TITLE, () -> setTitle(cardData.get("Title")));
        runnableHashMap.put(MEMBER, () -> setMembers(cardData.get("Members")));
        runnableHashMap.put(LABELS, () -> setLabels(Arrays.asList(cardData.get("Labels").split((",\\s*")))));
        return runnableHashMap;
    }

    /**
     * Gets all keys of the Card.
     *
     * @return a set of keys of Card attributes.
     */
    public Set<String> getCardKeys() {
        return cardKeys;
    }

    /**
     * This method is used to get id.
     *
     * @return a string with the id of card.
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to set id.
     *
     * @param id defines of input string with the id.
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * This method is used get list of members.
     *
     * @return a list with the members of card.
     */
    public List<String> getIdChecklists() {
        return idChecklists;
    }

    /**
     * This method is used to set idChecklists.
     *
     * @param idChecklists defines of input list with the idChecklists.
     */
    public void setIdChecklists(final List<String> idChecklists) {
        this.idChecklists = idChecklists;
    }

    /**
     * This method is used get members.
     *
     * @return a string with the members of card.
     */
    public String getMembers() {
        return members;
    }

    /**
     * This method is used to set members.
     *
     * @param members defines of input string with the members.
     */
    public void setMembers(final String members) {
        cardKeys.add(MEMBER);
        this.members = members;
    }

    /**
     * This method is used get list of label.
     *
     * @return a list with the labels of card.
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * This method is used to set labels.
     *
     * @param labels defines of input list with the labels.
     */
    public void setLabels(List<String> labels) {
        cardKeys.add(LABELS);
        this.labels = labels;
    }

    /**
     * This method is used get title.
     *
     * @return a string with the title of card.
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method is used to set title.
     *
     * @param title defines of input string with the title.
     */
    public void setTitle(final String title) {
        cardKeys.add(TITLE);
        this.title = title;
    }
}
