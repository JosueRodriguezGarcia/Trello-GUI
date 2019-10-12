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

package steps;

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
import trello.ui.components.ProvisionalTopMenu;
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
    private ProvisionalTopMenu provisionalTopMenu;
    private TopMenu topMenuOfHome;
    private User user;
    private Context context;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public CommonSteps(final Context currentContext) {
        this.context = currentContext;
    }

    /**
     * Verifies if the user is logged in as given user type.
     * If the user it is not logged in or if it is another user that is logged in, the method proceeds with the
     * login of the given user.
     *
     * @param userType of the user which is wanted to get logged in.
     */
    @Given("I am logged in as (.*) user")
    public void verifyLoggedInByUserType(final String userType) {
        PageTransporter.navigateToURL(NamePages.getHomePageUrl(context.getUser().getUsername()));
        provisionalTopMenu = new ProvisionalTopMenu();
        user = JsonConverter.jsonToUser(ReadJsonFile.getInstance().getDataByUserType(userType));
        if(provisionalTopMenu.isLoginButtonDisplayed()) {
            PageTransporter.navigateToURL(NamePages.getLoginPageUrl());
            loginPage = new LoginPage();
            loginPage.login(user);
        } else {
            homePage = new HomePage();
            String userInitials = homePage.getTopMenu().getFullNameInitials();
            if (!user.getFullNameInitials().equals(userInitials)) {
                topMenuOfHome.logoutPage();
                PageTransporter.navigateToURL(NamePages.getLoginPageUrl());
                loginPage = new LoginPage();
                loginPage.login(user);
            }
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
