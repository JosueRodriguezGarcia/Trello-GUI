Feature: List actions

  @ArchiveList
  Scenario: New list creation
    Given I log in as admin user
    When I select TestBoard board
    And I create a new list with "TestList" as title
    Then I should see the new created list with the given title

  Scenario: Move list
    #Given I go to home page
    Given I log in as admin user
    And I select TestBoard board
    #And there are two lists
    When I move Tasks1 from first to last position
    Then I should see the list moved to the position correctly
