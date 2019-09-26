package trello.ui.pages;

import core.selenium.util.WebDriverMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import trello.entities.User;

/**
 * AtlassianPage class.
 *
 * @author Josue Rodriguez Garcia
 * @version 0.0.1
 */
public class AtlassianPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement loginSubmitButton;

    /**
     * This method is used to fill username field.
     *
     * @param userEmail defines a input string with username.
     */
    private void fillUsernameField(final String userEmail) {
        WebDriverMethod.setTxtElement(usernameField, userEmail);
    }

    /**
     * This method is used to fill username field.
     *
     * @param password defines a input string with password.
     */
    private void fillPasswordField(final String password) {
        WebDriverMethod.findElementBeClickable(driver, passwordField);
        WebDriverMethod.setTxtElement(passwordField, password);
    }

    /**
     * this method is used to click in button.
     */
    private void clickLoginSubmitButton() {
        loginSubmitButton.click();
    }

    /**
     * This method is used to login.
     *
     * @param user defines a input string with user type.
     */
    public void login(final User user) {
        fillUsernameField(user.getEmail());
        clickLoginSubmitButton();
        fillPasswordField(user.getPassword());
        clickLoginSubmitButton();
    }

    @Override
    protected void waitUntilPageObjectIsLoaded() {
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton));
    }
}
