Feature: Search in page

# @BrandsNumber
# Scenario: Obtain the brands number enable for vahicle
#     Given I go to navigate to www.mercadolibre.com
#     When select the categories opcion on nav bar
#     And select the car option
#     Then validate de number brands enable

@CarsBrandsNumber
Scenario Outline: Obtain the numbers cars for brands
    Given I go to navigate to www.mercadolibre.com
    When select the categories opcion on nav bar
    And select the car option
    And I enter a car brand <Make>
    Then validate de number car <Results>

    Examples:
        | Make   | Results |
        | BMW    | 2.292   |
        | Mazda  | 4.339   |
