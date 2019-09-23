Feature: login
  Scenario: Successful log in as Admin user
    Given I go to "login" page
    When I log in as "Admin" user
    Then I should see the initial user's full name