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

import core.selenium.util.WebDriverMethod;

import java.util.*;
import java.util.List;

import static trello.keys.CardKeys.*;

/**
 * Card class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class Card {

    private String id;
    private String title;
    private List<Member> members;
    private String member;
    private List<String> labels;
    private Set<String> cardKeys = new HashSet<String>();

    /**
     * Constructor of this class.
     */
    public Card() {
        labels = new ArrayList();
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
     * This method is used get title.
     *
     * @return a string with the title of card.
     */
    public String getTitle() {
        return title;
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
     * @param labels defines of input string with the labels.
     */
    public void setLabels(final String labels) {
        cardKeys.add(LABELS);
        this.labels = Arrays.asList(labels.split(("\\s*,\\s*")));
    }

    /**
     * This method is used to set title.
     *
     * @param title defines of input string with the title.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    /**
     * Gets a list of members.
     *
     * @return a list.
     */
    public List<Member> getMembers() {
        return members;
    }

    /**
     * Sets a list the members.
     *
     * @param members defines a input list with the members to be set.
     */
    public void setMembers(final List<String> members) {
        this.members = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            this.members.add(new Member());
            this.members.get(i).setFullName(members.get(i));
            this.members.get(i).setInitials(WebDriverMethod.getFullNameInitials(members.get(i)));
        }
    }

    /**
     * This method is used get members.
     *
     * @return a string with the members of card.
     */
    public String getMember() {
        return member;
    }
    /**
     * This method is used to set member.
     *
     * @param member defines of input string with the member.
     */
    public void setMember(final String member) {
        cardKeys.add(MEMBER);
        this.member = member;
    }

    /**
     * Sets all values send into cardData parameter.
     *
     * @param cardData is the card data into Map.
     */
    public void addDataToCard(final Map<String, String> cardData) {
        HashMap<String, Runnable> runnableMap = composeRunnableMap(cardData);
        cardData.keySet().forEach(key -> runnableMap.get(key).run());
    }

    /**
     * Gets the runnable Map with the cardData parameter.
     *
     * @param cardData is to get data of card.
     * @return an instance HashMap with keys and methods to run.
     */
    private HashMap<String, Runnable> composeRunnableMap(final Map<String, String> cardData) {
        HashMap<String, Runnable> runnableHashMap = new HashMap<>();
        runnableHashMap.put(TITLE,  () -> setTitle(cardData.get(TITLE)));
        runnableHashMap.put(MEMBER, () -> setMember(cardData.get(MEMBER)));
        runnableHashMap.put(LABELS, () -> setLabels(cardData.get(LABELS)));
        return runnableHashMap;
    }

}
