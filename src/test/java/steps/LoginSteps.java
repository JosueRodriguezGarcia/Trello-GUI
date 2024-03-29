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

import core.selenium.util.JsonConverter;
import core.selenium.util.JsonFileReader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import trello.entities.Context;
import trello.entities.User;
import trello.keys.NamePages;
import trello.ui.PageTransporter;
import trello.ui.components.TopMenu;
import trello.ui.pages.HomePage;
import trello.ui.pages.LoginPage;

/**
 * LoginSteps class.
 *
 * @author Raul Choque, Melissa Román
 * @version 0.0.1
 */
public class LoginSteps {

    private Context context;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public LoginSteps(final Context currentContext) {
        this.context = currentContext;
    }

    /**
     * Logs in as user type.
     *
     * @param userType use to select a user.
     */
    @When("I log in as (.*) user")
    public void loginAsUser(final String userType) {
        User user = JsonConverter.jsonToUser(JsonFileReader.getInstance().getDataByUserType(userType));
        context.setUser(user);
        PageTransporter.navigateToURL(NamePages.getLoginPageUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.login(user);
    }

    /**
     * Sees the initial of full name of user in HomePage.
     */
    @Then("I should see the user's full name initials")
    public void verifyFullNameInitials() {
        HomePage homePage = new HomePage();
        TopMenu topMenuOfHome = homePage.getTopMenu();
        Assert.assertEquals(topMenuOfHome.getFullNameInitials(), context.getUser().getFullNameInitials(),
                "This is not the user's home page.");
    }
}
