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

package trello.ui.components;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

/**
 * Menu class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class Menu implements IElement {

    private final WebElement element;
    private final Map<String, IElement> elements = new HashMap<>();

    /**
     * Constructor for create object of this class.
     *
     * @param element is to initialize the attribute element of this class.
     */
    public Menu(final WebElement element) {
        this.element = element;
        this.element.click();
    }

    /**
     * Open all elements pages selected with this class.
     */
    @Override
    public void openPage() {
        elements.forEach((key, element) -> element.openPage());
    }

    /**
     * Opens page, select a subMenu from this menu class.
     *
     * @param namePage is to search the name of page in the menu.
     */
    public void openPage(final String namePage) {
        elements.get(namePage).openPage();
    }

    /**
     * Adds element into the elements map.
     *
     * @param name is the key into the map.
     * @param element is the value into the map.
     */
    public void addElement(final String name, final IElement element) {
        elements.put(name, element);
    }
}
