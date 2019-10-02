Feature: List actions

  @ArchiveList @LogOut
  Scenario: New list creation
    Given I log in as admin user
    When I select TestBoard board
    And I create a new list with "TestList" as title
    Then I should see the new created list with the given title

  Scenario: Move all cards in list
    Given I am logged in as admin user
    When I select TestBoard board
    And I move all cards in Tasks1 to Tasks2
    Then all cards that where on source list should appear on target list

  Scenario: Sort cards in list by card name
    Given I am logged in as admin user
    When I select TestBoard board
    And I sort cards in Tasks1 by card name
    Then all cards should be correctly sorted

  Scenario: Copy a card to other list
    Given I am logged in as admin user
    When I select TestBoard board
    And I copy CardTitle card to List1 list
    Then the card appears correctly on target list