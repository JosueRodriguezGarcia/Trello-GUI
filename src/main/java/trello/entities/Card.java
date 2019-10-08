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

import java.util.List;

/**
 * Card class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class Card {

    private String id;
    private List<String> idChecklists;
    private List<String> idMembers;
    private List<Label> labels;
    private String title;

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
     * This method is used get list of idMembers.
     *
     * @return a list with the idMembers of card.
     */
    public List<String> getIdChecklists() {
        return idChecklists;
    }

    /**
     * This method is used to set idChecklists.
     *
     * @param idChecklists defines of input list with the idChecklists.
     */
    public void setIdChecklists(List<String> idChecklists) {
        this.idChecklists = idChecklists;
    }

    /**
     * This method is used get list of idMembers.
     *
     * @return a list with the idMembers of card.
     */
    public List<String> getIdMembers() {
        return idMembers;
    }

    /**
     * This method is used to set idMembers.
     *
     * @param idMembers defines of input list with the idMembers.
     */
    public void setIdMembers(List<String> idMembers) {
        this.idMembers = idMembers;
    }

    /**
     * This method is used get list of label.
     *
     * @return a list with the labels of card.
     */
    public List<Label> getLabels() {
        return labels;
    }

    /**
     * This method is used to set labels.
     *
     * @param labels defines of input list with the labels.
     */
    public void setLabels(List<Label> labels) {
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
        this.title = title;
    }
}
