@Raul
Feature: Team creation

  Background: I am logged in as given user type.
    Given I am logged in as admin user

  @DeleteTeam
  Scenario: Create a team
    When I add a new team with this information "nameTeam"
    And I add the following members with username:
      | josephtaylor63 |
      | jamescooper156 |
      | georgesmith118 |
    Then I should see the information of team
    When I go to the section of member in TeamPage
    Then I should see all username of members
    When I go to the Home page using top menu
    Then I should see the name of team
