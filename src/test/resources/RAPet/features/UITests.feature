Feature: Testing UI

  Scenario: Logging to Swag Labs
    Given I opened Swag Labs homepage
    When I login with credentials:
      | username      | password     |
      | standard_user | secret_sauce |
    Then I am on page URL ending in 'inventory.html'


  Scenario: Check adding to Shopping Cart
    Given I opened Swag Labs homepage
    When I login with credentials:
      | username      | password     |
      | standard_user | secret_sauce |
    And I add 'Sauce Labs Backpack' to the Shopping Cart
    And I add 'Sauce Labs Bolt T-Shirt' to the Shopping Cart
    And I open Shopping Cart
    Then 'Sauce Labs Backpack' should be in the Shopping Cart