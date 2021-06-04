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


  Scenario: Get list of users in Reqres and check last name of defined user (ScenarioContext)
    Given I get last name of user on page '2', who is '2' on page
    Then the last name of the user is 'Ferguson'


  Scenario: Get user data from list of users (Serenity SessionVariable)
    Given I get data of user on page '2', who is '1' on page
    Then I check that the last name is 'Lawson'


  Scenario: Get list of users in Reqres and check email of defined user (ScenarioContext)
    Given I get response data of users on page '2'
    Then the email of the '2' user is 'lindsay.ferguson@reqres.in'


  Scenario: Login as a user in Reqres
    Given I login as a Reqres user 'eve.holt@reqres.in' with password 'cityslicka'
