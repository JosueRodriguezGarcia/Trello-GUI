Feature: Team creation

  Scenario: Create a team
    Given I log in as admin user
    When I add a new team with this information "nameTeam" and "description"
    And I add the following members with user name:
      | josephtaylor63 |
      | jamescooper156 |
      | georgesmith118 |
    Then I should see the information of team
    When I go to the section of member information
    Then I should see the full name of members