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

//    @FindBy(className = "pika-select-month")
//    private List<WebElement> monthDropdown;

    @FindBy(className = "pika-select-year")
    private List<WebElement> yearDropdown;

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
     * clicks in the remove button.
     */
    public void clickRemoveButton(){
        removeButton.click();
    }
    /**
     * clicks in the save button.
     */
    public void clickSaveButton(){
        saveButton.click();
    }

    public void clickMonthButton() {
        monthButton.click();
        List<WebElement> months = monthButton.findElements(By.className("pika-select-month"));
        months.get(3).click();
        System.out.println(months.get(3).getText());
    }

    public void setMonth(final String month) {
//        monthDropdown.get(0).click();
//        for (int i =0; i<monthDropdown.size(); i++){
//            System.out.println(monthDropdown.get(i).getText());
//            if(monthDropdown.get(i).getText().equals(month)){
//                System.out.println("hola");
//            }
//        }
    }

    public void showMonth() {
//        System.out.println(monthDropdown.get(2).getText());
//        for(int i= 0; i<monthDropdown.size(); i++){
//            System.out.println(monthDropdown.get(i).getText());
//        }
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {

    }
}
