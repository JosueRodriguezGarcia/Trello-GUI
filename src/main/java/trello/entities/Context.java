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
    private List list;
    private Card card;

    /**
     * Method constructor of Context class.
     */
    public Context() {
        user = new User();
        board = new Board();
        list = new List();
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
     * Sets context's user.
     *
     * @param board is the user to be shared in context.
     */
    public void setBoard(final Board board) {
        this.board = board;
    }

    /**
     * Gets the context's list.
     *
     * @return the list that is on the context.
     */
    public List getList() {
        return list;
    }

    /**
     * Sets context's user.
     *
     * @param list is the user to be shared in context.
     */
    public void setList(final List list) {
        this.list = list;
    }

    /**
     * Gets the context's card.
     *
     * @return the card that is on the context.
     */
    public Card getCard() {
        return card;
    }

    /**
     * Sets context's user.
     *
     * @param card is the user to be shared in context.
     */
    public void setCard(final Card card) {
        this.card = card;
    }
}
