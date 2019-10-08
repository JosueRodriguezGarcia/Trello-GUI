package trello.steps;

import core.selenium.WebDriverConfig;
import core.selenium.WebDriverManager;
import core.selenium.util.JsonConverter;
import core.selenium.util.ReadJsonFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import trello.entities.Context;
import trello.entities.User;
import trello.keys.NamePages;
import trello.ui.PageTransporter;
import trello.ui.components.TopMenu;
import trello.ui.pages.HomePage;
import trello.ui.pages.LoginPage;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * CommonSteps class.
 *
 * @author Melissa Román
 * @version 0.0.1
 */

public class CommonSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private User user;
    private Context context;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public CommonSteps(final Context currentContext) {
        this.context = currentContext;
        this.user = context.getUser();
    }

    /**
     * Verifies if the user is logged in as given user type.
     * If the user it is not logged in or if it is another user that is logged the method proceeds with the
     * login of the given user.
     *
     * @param userType of the user which is wanted to get logged in.
     */
    @Given("I am logged in as (.*) user")
    public void verifyLoggedInByUserType(final String userType) {
        PageTransporter.navigateToURL(NamePages.getHomePageUrl(user.getUsername()));
        homePage = new HomePage();
        TopMenu topMenuOfHome = homePage.getTopMenu();
        user = JsonConverter.jsonToUser(ReadJsonFile.getInstance().getDataByUserType(userType));
        final long time = 1;
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        webDriver.
                manage().
                timeouts().
                implicitlyWait(time, TimeUnit.SECONDS);
        try {
            String userInitials = topMenuOfHome.getFullNameInitials();
            if (!user.getFullNameInitials().equals(userInitials)) {
                topMenuOfHome.logoutPage();
                PageTransporter.navigateToURL(NamePages.getLoginPageUrl());
                loginPage = new LoginPage();
                loginPage.login(user);
            }
        } catch (NoSuchElementException nse) {
            PageTransporter.navigateToURL(NamePages.getLoginPageUrl());
            loginPage = new LoginPage();
            loginPage.login(user);
        } finally {
            webDriver.
                    manage().
                    timeouts().
                    implicitlyWait(WebDriverConfig.getInstance().getImplicitWaitTime(), TimeUnit.SECONDS);
        }
    }

    /**
     * Goes to the HomePage using TopMenu.
     */
    @When("I go to the Home page using top menu")
    public void goToHomePageUsingTopMenu() {
        TopMenu topMenu = new TopMenu();
        Actions action = new Actions(topMenu.getDriver());
        action.sendKeys(Keys.ESCAPE).build().perform();
        topMenu.openHomePage();
    }
}
