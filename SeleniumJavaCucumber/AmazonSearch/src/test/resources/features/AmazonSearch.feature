Feature: Search Amazon

Scenario: Search amazon and select item
    Given I access in www.amazon.com
    When Search for alexa
    When selects the third item
    Then the user is able to add it to the cart




    