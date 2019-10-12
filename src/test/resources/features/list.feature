Feature: List actions

  @CreateList
  Scenario: New list creation
    Given I log in as admin user
    When I select BoardForList board
    And I create a new list with "ListTest" as title
    Then I should see the new created list with the given title

  @MoveAllCards
  Scenario: Move all cards in list
    Given I am logged in as admin user
    And I select TestBoard board
    And there are following lists in the board
      | SourceList |
      | TargetList |
    When I move all cards in SourceList to TargetList
    Then all cards that were on source list should appear on target list
    And the source list should be empty

  @SortCardsByName
  Scenario: Sort cards in list by card name
    Given I am logged in as admin user
    And I select TestBoard board
    When I sort cards in SourceList list by card name
    Then all cards should be displayed correctly sorted

  @CopyACard
  Scenario: Copy a card to other list
    Given I am logged in as admin user
    When I select TestBoard board
    And I copy Card1 card to TargetList list
    Then the card appears correctly on source and target list
