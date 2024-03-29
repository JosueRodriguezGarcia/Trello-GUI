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

package trello.ui.pages.modal;

import core.selenium.util.DateMethod;
import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.ui.pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DueDataModal class.
 *
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class DueDataModal extends BasePage {

    @FindBy(className = "pop-over-header-title")
    private WebElement headerTitle;

    @FindBy(className = "pop-over-header-close-btn")
    private WebElement closeButton;

    @FindBy(className = "js-dpicker-date-input")
    private WebElement dataField;

    @FindBy(className = "js-dpicker-time-input")
    private WebElement timeField;

    @FindBy(className = "pika-select-month")
    private WebElement monthButton;

    @FindBy(className = "pika-select-year")
    private WebElement yearButton;

    @FindBy(className = "pika-day")
    private List<WebElement> dayButton;

    @FindBy(className = "js-custom-reminder")
    private WebElement reminderButton;

    @FindBy(css = "input.primary.wide.confirm")
    private WebElement saveButton;

    @FindBy(className = "js-remove-date")
    private WebElement removeButton;

    @FindBy(className = "js-dpicker-date-input")
    private WebElement dateField;

    /**
     * Gets the Modal Title.
     *
     * @return a string with the Title.
     */
    public String title() {
        return headerTitle.getText();
    }

    /**
     * Does click in the close button.
     *
     * @return a instance of CardModal.
     */
    public CardModal clickCloseButton() {
        closeButton.click();
        return new CardModal();
    }

    /**
     * Does click in the remove button.
     *
     * @return a instance of CardModal.
     */
    public CardModal clickRemoveButton() {
        removeButton.click();
        return new CardModal();
    }

    /**
     * Does click in the save button.
     *
     * @return a instance of CardModal
     */
    public CardModal clickSaveButton() {
        saveButton.click();
        return new CardModal();
    }

    /**
     * Does click in the month button.
     */
    public void clickMonthButton() {
        monthButton.click();
    }

    /**
     * Does click in year button.
     */
    public void clickYearButton() {
        yearButton.click();
    }

    /**
     * Does click in reminder button.
     */
    public void clickReminderButton() {
        reminderButton.click();
    }

    /**
     * Does clear in hour field.
     */
    private void clearHourField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='';", timeField);
    }

    /**
     * Fills the date Field.
     *
     * @param addDay defines a input string with the number of day to be add.
     */
    public void fillDateFields(final String addDay) {
        String newDate = DateMethod.getDate(addDay);
        fillDateField(DateMethod.getOnlyDate(newDate));
        fillTimeField(DateMethod.getOnlyTime(newDate));
    }

    /**
     * Fills the date Field.
     *
     * @param date defines a input string with the number of day to be add.
     */
    public void fillDateField(final String date) {
        WebDriverMethod.setTxtElement(dataField, date);
    }

    /**
     * Fills the hour Field.
     *
     * @param time defines a number of hour to by set.
     */
    public void fillTimeField(final String time) {
        clearHourField();
        WebDriverMethod.setTxtElement(timeField, time);
    }

    /**
     * Sets the month in calendar.
     *
     * @param month defines a input string with the month to be set.
     */
    public void setMonth(final String month) {
        monthButton.findElement(By.xpath("//option[.='" + month + "']")).click();
    }

    /**
     * Sets the year in calendar.
     *
     * @param year defines a input string with the year to be set.
     */
    public void setYear(final String year) {
        yearButton.findElement(By.xpath("//option[.='" + year + "']")).click();
    }

    /**
     * Selects a day in calendar.
     *
     * @param day defines a input string with the day to by set.
     */
    public void setDay(final String day) {
        for (int i = 0; i < dayButton.size(); i++) {
            if (dayButton.get(i).getText().equals(day)) {
                dayButton.get(i).click();
                break;
            }
        }
    }

    /**
     * Select a reminder.
     *
     * @param reminder defines a input string with the reminder to by set.
     */
    public void setReminder(final String reminder) {
        reminderButton.click();
        reminderButton.findElement(By.xpath("//option[.='" + reminder + "']")).click();
    }

    /**
     * Gets the value of the field date.
     *
     * @return a string with the date.
     */
    public String getDate() {
        return dataField.getAttribute("value");
    }

    /**
     * Gets the value of the field time.
     *
     * @return a string with the time.
     */
    public String getTime() {
        return timeField.getAttribute("value");
    }

    /**
     * Waits that save button to be clickable.
     */
    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
    }

    /**
     * Sets the attributes the a due date.
     *
     * @param dataTable defines a input map with the information to be set.
     */
    public void setInformation(final Map<String, String> dataTable) {
        HashMap<String, Runnable> cmdList = new HashMap<>();
        cmdList.put("Date", () -> fillDateFields(dataTable.get("Date")));
        cmdList.put("Reminder", () -> setReminder(dataTable.get("Reminder")));
        dataTable.keySet().forEach(key -> cmdList.get(key).run());
    }
}
