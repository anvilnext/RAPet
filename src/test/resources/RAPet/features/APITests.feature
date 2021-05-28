Feature: Testing API


  Scenario: Posting user in Petstore
    Given I post next user in PetStore:
      | id | username | firstName | lastName | email           | password | phone   | userStatus |
      | 0  | user1    | Name      | Lastname | email@email.com | dhKsf2@  | 0006444 | 0          |
    Then I get next user 'user1' in PetStore


  Scenario: Putting changes to existing user in Petstore
    Given I put changes to user 'user1' in PetStore:
      | id | username | firstName | lastName     | email           | password | phone   | userStatus |
      | 0  | user123  | Nameaa    | Lastnamedwww | email@email.com | dhKsf2@  | 0006444 | 0          |
    Then I get next user 'user123' in PetStore


  Scenario: Login as a user in Petstore
    Given I login as a user 'user1' with password 'pass1'


  Scenario: Get list of users in Reqres and check last name of defined user
    Given I get last name of user on page '2', who is '2' on page, and the name is 'Ferguson'


  Scenario: Get user data from list of users
    Given I get data of user on page '2', who is '1' on page, and last name is 'Lawson'


  Scenario: Login as a user in Reqres
    Given I login as a Reqres user 'eve.holt@reqres.in' with password 'cityslicka'
