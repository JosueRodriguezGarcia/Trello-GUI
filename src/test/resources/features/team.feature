Feature: Team creation

  Scenario: Create a team
    Given I log in as admin user
    When I add a new team with this information "nameTeam" and "description"
    And I add the following members:
      | fullNameMember |
      | email1 |
      | email2 |
      | email3 |
    Then I should see the imformation of team
    When I go to the section of member information
    Then I should see the full name of members