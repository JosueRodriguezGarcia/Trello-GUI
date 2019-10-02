Feature: List actions

  @ArchiveList @LogOut
  Scenario: New list creation
    Given I log in as admin user
    When I select TestBoard board
    And I create a new list with "TestList" as title
    Then I should see the new created list with the given title
    