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

import java.util.HashMap;
import java.util.Map;

/**
 * Context class.
 *
 * @author Raul Choque, Josue Rodriguez.
 * @version 0.0.1
 */
public class Context {

    private Board board;
    private Card card;
    private Map<String, List> lists;
    private Team team;
    private User user;

    /**
     * Method constructor of Context class.
     */
    public Context() {
        board = new Board();
        card = new Card();
        lists = new HashMap<>();
        team = new Team();
        user = new User();
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
     * Gets the map that contains the lists.
     *
     * @return lists map.
     */
    public Map<String, List> getLists() {
        return lists;
    }

    /**
     * Gets team attribute of it's class.
     *
     * @return a Team object.
     */
    public Team getTeam() {
        return team;
    }

    /**
     * Sets team attribute of it's class.
     *
     * @param team is the team to be set.
     */
    public void setTeam(final Team team) {
        this.team = team;
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
}
