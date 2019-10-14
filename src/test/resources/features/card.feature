Feature: Card actions

#  @create-board @create-list @delete-board
#  Scenario: Create a card correctly
#    Given I log in as admin user
#     When I select BoardTest board
#      And I add a card to ListTest list with newCard as task
#     Then I should see the new card with the given task
#     Then I verify that the name is the correct
#
#  @create-board @create-list @create-card @delete-board
#  Scenario: Add a checklist to a card
#    Given I log in as admin user
#     When I select BoardTest board
#      And I select CardTest card
#      And I add a checklist with TestCheckList title
#     Then the checklist section is displayed on the card details
#
#  @create-board @create-list @create-card @delete-board
#  Scenario: Assign a date to a card
#    Given I log in as admin user
#     When I select BoardTest board
#      And I select CardTest card
#      And I assign a due date
#        | Date     | One day from now |
#        | Reminder | None             |
#     Then The due date section is displayed on the card details
#
#  @create-board @create-list @create-card @add-member @delete-board
#  Scenario: Assign card to a member
#    Given I log in as admin user
#      And I select BoardTest board
#     When I select CardTest card
#      And I add a member
#        | George Smith  |
#        | James Cooper  |
#        | Joseph Taylor |
#     Then the member's initials are shown in the card

  Background: I am logged in as given user type.
    Given I am logged in as admin user

  @CreateBoard @delete-card
  Scenario: Create a Card in List "List to card",
    it is into a Board with name "Board to card".
#    Given I log in as admin user
    When I go to the Board
      And I create a new Card with data:
        | Title   | Card to test |
        | Member  | tester       |
        | Labels  | red, blue    |
    Then I should see the data of new Card

  @delete-card @create-board @create-list @delete-board
  Scenario: Create a Card in List "List to card",
  it is into a Board with name "Board to card".
#    Given I log in as admin user
    When I go to the Board
    And I create a new Card with data:
      | Title   | testing a Card |
    Then I should see the data of new Card