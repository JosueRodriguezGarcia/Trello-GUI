Feature: Action board create, copy to a team and add a Power up application

  @delete-board
  Scenario: Create a Board successfully with required data, using the button "Create new board" of Home Page.
    Given I log in as admin user
    When I create a new Board with name "New Board to test"
    Then I should see the name of Board in BoardPage
    When I go to the Home page using top menu
    Then I should see the Board in the Recently Viewed section
      And I should see the Board in the Personal Boards section
