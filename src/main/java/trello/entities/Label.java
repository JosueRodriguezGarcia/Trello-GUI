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
 * Label class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Label {

    private String color;
    private String id;
    private String idBoard;
    private String name;

    /**
     * This method is used to get color.
     *
     * @return a string with the color of label.
     */
    public String getColor() {
        return color;
    }

    /**
     * This method is used to set color.
     *
     * @param color defines of input string with the color.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This method is used to get id.
     *
     * @return a string with the id of label.
     */
    public String getId() {
        return id;
    }

    /**
     * This method is used to set id.
     *
     * @param id defines of input string with the id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method is used to get idBoard.
     *
     * @return a string with the idBoard of label.
     */
    public String getIdBoard() {
        return idBoard;
    }

    /**
     * This method is used to set idBoard.
     *
     * @param idBoard defines of input string with the idBoard.
     */
    public void setIdBoard(String idBoard) {
        this.idBoard = idBoard;
    }

    /**
     * This method is used to get name.
     *
     * @return a string with the name of label.
     */
    public String getName() {
        return name;
    }

    /**
     * This method is used to set name.
     *
     * @param name defines of input string with the name.
     */
    public void setName(String name) {
        this.name = name;
    }
}
