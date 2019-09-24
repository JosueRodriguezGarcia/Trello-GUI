Feature: Log in into the page Trello as Admin user

  Scenario: Successful log in as Admin user
    When I log in as Admin user
    Then I should see the initial user's full name
