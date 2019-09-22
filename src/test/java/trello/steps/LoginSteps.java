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

package trello.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entities.Context;
import trello.entities.User;
import trello.keys.NamePages;
import trello.ui.PageTransporter;
import trello.ui.pages.HomePage;
import trello.ui.pages.LoginPage;

/**
 * LoginSteps class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class LoginSteps {

    private Context context;
    private User user;
    private LoginPage loginPage;
    private HomePage homePage;
    private NamePages namePages;

    /**
     * Constructor method for share states between objects.
     *
     * @param context has all share entities.
     */
    public LoginSteps(final Context context) {
        this.context = context;
        this.user = context.getUser();
    }


    /**
     * Logs in as user type.
     *
     * @param userType use to select a user.
     */
    @When("I log in as {string} user")
    public void loginAsUser(final String userType) {
        user.initialize(userType);
        namePages = new NamePages(context);
        PageTransporter.navigateToURL(namePages.getLoginPage());
        loginPage = new LoginPage();
        loginPage.login(user);
    }

    /**
     * Sees the initial of full name of user in HomePage.
     */
    @Then("I should see the initial user's full name")
    public void seeInitialUserFullName() {
        PageTransporter.navigateToURL(namePages.getHomePage());
        homePage = new HomePage();
        Assert.assertEquals(homePage.getInitialFullName(), user.getInitialFullName(),
                "This is not the user's page.");
    }
}
