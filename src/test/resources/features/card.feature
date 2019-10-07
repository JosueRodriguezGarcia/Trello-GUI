Feature: Card actions

  @create-board @create-list @delete-board
  Scenario: Create a card correctly
    Given I log in as admin user
     When I select TestBoard board
      And I add a card to TestList list with newCard as task
     Then I should see the new card with the given task
     Then I verify that the name is the correct

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Add a checklist to a card
    Given I log in as admin user
     When I select TestBoard board
      And I select TestCard card
      And I add a checklist with TestCheckList title
     Then the checklist section is displayed on the card details

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Assign a date to a card
    Given I log in as admin user
     When I select TestBoard board
      And I select TestCard card
      And I assign a due date
        | Date     | Today             |
        | Time     | One hour from now |
        | Reminder | None              |
     Then The due date section is displayed on the card details

  @create-board @create-list @create-card @delete-card @delete-board
  Scenario: Assign card to a member
    Given I log in as admin user
     When I select TestBoard board
      And I add members to board
        | george.smith.tr3110@gmail.com   |
        | james.cooper.tr3110@outlook.com |
        | joseph.taylor.tr3110@mail.com   |
     When I select TestCard card
      And I add a member
        | George Smith  |
        | James Cooper  |
        | Joseph Taylor |
     Then the member's initials are shown in the card
