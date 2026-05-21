Feature: Flow E2E in Sauce demo

  Background:
    Given a user logs in the home page for sauce demo

  @regression
  Scenario: Select products and complete the purchase correctly
    When the user add two products
    And select the cart by click on checkout
    And complete information and continue
    Then finish with de purchase
    And the system display a message "Thank you for your order!"