Feature: List actions

  @ArchiveList
  Scenario: New list creation
    Given I log in as admin user
    When I select TestBoard board
    And I create a new list with "ListTest" as title
    Then I should see the new created list with the given title

  @MoveAllCards
  Scenario: Move all cards in list
    Given I am logged in as admin user
    When I select TestBoard board
    And I move all cards in Tasks1 to Tasks2
    Then all cards that were on source list should appear on target list
    And the source list should be empty

  @SortCardsByName
  Scenario: Sort cards in list by card name
    Given I am logged in as admin user
    When I select TestBoard board
    And I sort cards in Tasks1 list by card name
    Then all cards should be displayed correctly sorted

  Scenario: Copy a card to other list
    Given I am logged in as admin user
    When I select TestBoard board
    And I copy Card1 card to Tasks2 list
    Then the card appears correctly on target list
