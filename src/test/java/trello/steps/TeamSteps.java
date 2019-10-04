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
import trello.ui.pages.HomePage;
import trello.ui.pages.team.MemberModalPage;
import trello.ui.pages.team.TeamModalPage;
import trello.ui.pages.team.TeamPage;

import java.util.List;

/**
 * TeamSteps class.
 *
 * @author Raul Choque
 * @version 0.0.1
 */
public class TeamSteps {

    private Context context;
    private TeamPage teamPage;

    /**
     * Constructor method to share states between objects.
     *
     * @param currentContext has all share entities.
     */
    public TeamSteps (final Context currentContext) {
        this.context = currentContext;
    }

    /**
     * Creates a team with a name.
     *
     * @param name is the parameter required to create a team.
     */
    @When("I add a new team with this information {string}")
    public void createTeam(final String name) {
        context.getTeam().setName(name);
        HomePage homePage = new HomePage();
        homePage.getTopMenu().createTeam();
        TeamModalPage teamModalPage = new TeamModalPage();
        teamModalPage.createTeam(context.getTeam());
    }

    /**
     * Adds members to team.
     *
     * @param members is to add to team.
     */
    @When("I add the following members with username:")
    public void addMembers(final List<String> members) {
        MemberModalPage memberModalPage = new MemberModalPage();
        context.getTeam().setUsernameOfMember(members);
        memberModalPage.addMember(context.getTeam());
        context.getTeam().addMember(context.getUser().getUsername());
    }

    /**
     * Shows in the TeamPage the name of team that was created.
     */
    @Then("I should see the information of team")
    public void showInformationTeam() {
        teamPage = new TeamPage();
        Assert.assertEquals(context.getTeam().getName(), teamPage.getNameTeam(),
                "The name of team is't the team that you created!!");
    }

    /**
     * Goes to te member section into TeamPage.
     */
    @When("I go to the section of member in TeamPage")
    public void sectionMemberInTeamPage() {
        teamPage.openMemberSection();
    }

    /**
     * Sees all member that added to team in member section.
     */
    @Then("I should see all username of members")
    public void seeAccountOfMembers() {
        Assert.assertEquals(context.getTeam().getUserNameOfMembers(), teamPage.getUserNameOfMembers(),
                "This member not are all that you add!!");
    }

    /**
     * Goes to the HomePage.
     */
    @When("I go to the Home page")
    public void goToHomePage() {
        teamPage.getTopMenu().openHomePage();
    }

    /**
     * Verify if has the name of team.
     */
    @Then("I should see the name of team")
    public void seeNameOfTeam() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.existNameOfTeam(context.getTeam().getName()));
    }
}
