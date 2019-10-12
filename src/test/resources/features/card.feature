Feature: Card actions

  Background: I am logged in as given user type.
    Given I am logged in as admin user

  @CreateCard
  Scenario: Create a card correctly
     When I select BoardForCard board
      And I add a card to ListForCard list with newCard as task
     Then I should see the new card with the given task
     Then I verify that the name is the correct

  @AssignChecklist
  Scenario: Add a checklist to a card
     When I select BoardForCard board
      And I select CardForChecklist card
      And I add a checklist with TestCheckList title
     Then the checklist section is displayed on the card details

  @AssignDueDate
  Scenario: Assign a date to a card
     When I select BoardForCard board
      And I select CardForDueDate card
      And I assign a due date
        | Date     | One day from now |
        | Reminder | None             |
     Then The due date section is displayed on the card details

  @AssignMembers
  Scenario: Assign card to a member
      And I select BoardForCard board
     When I select CardAddMembers card
      And I add a member
        | George Smith  |
        | James Cooper  |
        | Joseph Taylor |
     Then the member's initials are shown in the card
