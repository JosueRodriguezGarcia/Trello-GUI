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

package trello.entities;

/**
 * Context class.
 *
 * @author Raul Choque, Josue Rodriguez.
 * @version 0.0.1
 */
public class Context {

    private User user;
    private Board board;
    private List listSource;
    private List listTarget;
    private List list;
    private Card card;

    /**
     * Method constructor of Context class.
     */
    public Context() {
        user = new User();
        board = new Board();
        list = new List();
        listSource = new List();
        listTarget = new List();
        card = new Card();
    }

    /**
     * Gets User attribute of its class.
     *
     * @return the User attribute.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets context's user.
     *
     * @param user is the user to be shared in context.
     */
    public void setUser(final User user) {
        this.user = user;
    }

    /**
     * Gets Board attribute of its class.
     *
     * @return the Board attribute.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Sets board.
     *
     * @param board is the card to be set.
     */
    public void setBoard(final Board board) {
        this.board = board;
    }

    /**
     * Gets the source list to be used in the context.
     *
     * @return is the source list.
     */
    public List getListSource() {
        return listSource;
    }

    /**
     * Sets the source list to be used in the context.
     *
     * @param listSource is the source list to be set.
     */
    public void setListSource(final List listSource) {
        this.listSource = listSource;
    }

    /**
     * Gets card.
     *
     * @return the card that is on the context.
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets card.
     *
     * @param card is the card to be set.
     */
    public void setCard(final Card card) {
        this.card = card;
    }

    /**
     * Gets the target list used in the context.
     *
     * @return the target list.
     */
    public List getListTarget() {
        return listTarget;
    }

    /**
     * Sets the target list that will be on the context.
     *
     * @param listTarget is the target list that will be shared.
     */
    public void setListTarget(List listTarget) {
        this.listTarget = listTarget;
    }

    /**
     * Gets context list.
     *
     * @return the list in context.
     */
    public List getList() {
        return list;
    }

    /**
     * Sets the list in context.
     *
     * @param list is the list to be set in context.
     */
    public void setList(List list) {
        this.list = list;
    }
}
