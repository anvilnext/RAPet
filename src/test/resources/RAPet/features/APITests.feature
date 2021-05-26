Feature: Testing API


  Scenario: Posting user
    Given I post next user in PetStore:
      | id | username | firstName | lastName | email           | password | phone   | userStatus |
      | 0  | user1    | Name      | Lastname | email@email.com | dhKsf2@  | 0006444 | 0          |
    Then I get next user 'user1' in PetStore


  Scenario: Putting changes to existing user
    Given I put changes to user 'user1' in PetStore:
      | id | username | firstName | lastName     | email           | password | phone   | userStatus |
      | 0  | user123  | Nameaa    | Lastnamedwww | email@email.com | dhKsf2@  | 0006444 | 0          |
    Then I get next user 'user123' in PetStore


  Scenario: Login as a user
    Given I login as a user 'user1' with password 'pass1'
