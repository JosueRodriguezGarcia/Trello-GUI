Feature: Log in into the page Trello as Admin user

  @LogOut
  Scenario: Successful log in as Admin user
    When I log in as admin user
    Then I should see the user's full name initials
