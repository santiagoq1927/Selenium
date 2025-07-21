Feature: Searching in Google

@SearchGoogle
Scenario: I can seach something through the search bar the Google
    Given I navegate in www.google.com
    When I enter a text in search bar 
    When and select is search
    Then the text status is visible
    Then the results  match the criteria

# @Test
# Scenario: As a Test Engineer, I want to validate that text is present inside the list
#     Given I navigate to the list page
#     When I search the list
#     Then I can find the text in the list



    