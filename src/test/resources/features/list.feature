Feature: List actions

  @ArchiveList
  Scenario: New list creation
    Given I log in as "Admin" user
    When I select a board
    And I create a new list with TestList title
    Then I should see the new created list with the given title