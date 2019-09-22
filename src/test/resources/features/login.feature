Feature: Log in into the page Trello as Admin user

  Scenario: Successful log in as Admin user
    Given I am in the trello page
    When I go to the "Login" page
    Then I should see the initial user's full name
