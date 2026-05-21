Feature: Detail product page the Sauce demo

  Background:
    Given a user access product detail with name "Sauce Labs Fleece Jacket"

  @smoke
  Scenario: Verify product detail page elements
    Then the user verify the elements in the product detail page