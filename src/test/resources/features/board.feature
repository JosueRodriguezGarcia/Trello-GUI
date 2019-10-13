Feature: Action board create, copy to a team and add a Power up application

  Background: I am logged in as given user type.
    Given I am logged in as admin user

#  @DeleteBoard
#  Scenario: Create a Board successfully with required data, using the button "Create new board" of Home Page.
#    When I create a new Board with name "New Board to test"
#    Then I should see the name of Board in BoardPage
#    When I go to the Home page using top menu
#    Then I should see the Board in the Recently Viewed section
#      And I should see the Board in the Personal Boards section

  @CreateTeam @DeleteBoard @DeleteTeam
  Scenario: Copy a Board to Team "Team to test", given these exist.
    When I create a new Board with name "New Board to team"
      And I copy this Board to Team with same title Board
    Then I should see that this Board belongs to Team
    When I go to the Home page using top menu
    Then I should see the Board in the Team to test section
#    When I open the Board from Personal Boards section