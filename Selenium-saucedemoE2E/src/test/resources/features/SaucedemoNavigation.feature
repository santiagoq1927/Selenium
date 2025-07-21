Feature: Navigation suacedemo

Background: I enter to saucedemo page
    Given I navigate in soucedemo page
    When enter username, password and continue
    Then I am redirect to main page
    
Scenario: buy product in the store
    When select Sauce Labs Backpack element and add buy cart
    And go to cart and make checkout
    And enter information for send and finish buy
    Then informs the user order succesful