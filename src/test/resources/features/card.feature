Feature: Card actions

  Scenario: Create a card correctly
    Given I log in as admin user
    When I select TestBoard board
    And I add a card to TestList list with TestCard as task
    Then I should see the new card with the given task
