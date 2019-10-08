Feature: Card actions

#  Scenario: Create a card correctly
#    Given I log in as admin user
#     When I select TestBoard board
#      And I add a card to TestList list with TestCard as task
#     Then I should see the new card with the given task
#     Then I verify that the name is the correct
#
#  Scenario: Add a checklist to a card
#    Given I log in as admin user
#     When I select TestBoard board
#      And I select TestCard card
#      And I add a checklist with TestCheckList title
#     Then the checklist section is displayed on the card details

  @create-board-empty @create-list-in-board-empty  @delete-board-empty
  Scenario: Create a Card with required or not required data.
    Given I log in as admin user
      And I am in my List
     When I create a new Card with data:
      | Title     | Card to test      |
      | Member    | tester            |
      | Label     | blue              |
      | Checklist | checklist to test |
    Then I should see the data of new Card