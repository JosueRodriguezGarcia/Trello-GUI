package trello.ui.pages.modal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import trello.ui.pages.BasePage;

import java.util.List;

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
    private List<WebElement> reminderDropdown;

    @FindBy(className = "primary wide confirm")
    private WebElement saveButton;

    @FindBy(className = "js-remove-date")
    private WebElement removeButton;

    private void printDay(){
        for (int i = 0 ; i< dayButton.size(); i++){

        }
    }

    /**
     * Gets the Modal Title.
     */
    public String Title(){
        return headerTitle.getText();
    }

    /**
     * Does click in the close button.
     */
    public void clickCloseButton() {
        closeButton.click();
    }
    /**
     * Does click in the remove button.
     */
    public void clickRemoveButton(){
        removeButton.click();
    }

    /**
     * Does click in the save button.
     */
    public void clickSaveButton(){
        saveButton.click();
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
     * Sets the month in calendar.
     *
     * @param month defines a input string with the month to be set.
     */
    public void setMonth(final String month) {
        monthButton.findElement(By.xpath("//option[.='"+month+"']")).click();
    }

    /**
     * Sets the year in calendar.
     *
     * @param year defines a input string with the year to be set.
     */
    public void setYear(final String year) {
        yearButton.findElement(By.xpath("//option[.='"+year+"']")).click();
    }

    public void setDay(final String day) {
        for(int i =0; i<dayButton.size();i++){
            if(dayButton.get(i).getText().equals(day)){
                dayButton.get(i).click();
                break;
            }
        }

    }
    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
