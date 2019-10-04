Feature: Team creation

  Scenario: Create a team
    Given I log in as admin user
    When I add a new team with this information "nameTeam"
    And I add the following members with username:
      | josephtaylor63 |
      | jamescooper156 |
      | georgesmith118 |
    Then I should see the information of team
    When I go to the section of member in TeamPage
    Then I should see all username of members