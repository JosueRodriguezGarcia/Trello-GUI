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
import trello.entities.Context;
import trello.entities.Team;
import trello.ui.pages.HomePage;
import trello.ui.pages.team.MemberModalPage;
import trello.ui.pages.team.TeamModalPage;

import java.util.List;

/**
 * TeamSteps class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TeamSteps {

    private Context context;
    private Team team;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public TeamSteps (final Context currentContext) {
        this.context = currentContext;
        this.team = context.getTeam();
    }

    @When("I add a new team with this information {string} and {string}")
    public void createTeam(String name, String description) {
        team.setName(name);
        HomePage homePage = new HomePage();
        homePage.getTopMenu().createTeam();
        TeamModalPage teamModalPage = new TeamModalPage();
        teamModalPage.createTeam(name);
    }

    @When("I add the following members with user name:")
    public void addMembers(List<String> members) {
        MemberModalPage memberModalPage = new MemberModalPage();
        memberModalPage.addMember(members);
    }

    @Then("I should see the information of team")
    public void showInformationTeam() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("I go to the section of member information")
    public void i_go_to_the_section_of_member_information() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I should see the full name of members")
    public void i_should_see_the_full_name_of_members() {
        // Write code here that turns the phrase above into concrete actions
    }
}
