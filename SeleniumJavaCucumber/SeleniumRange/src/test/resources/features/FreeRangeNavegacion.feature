@Navigation
Feature: Navigation bar
    To see the subpages
    Without loggin in
    I can clic the navigation bar links

    Background: I am on the Free Range Testers web without loggin in
        Given I navegate in www.freerunnertesters.com

    Scenario Outline: I can acces the subpages through the navigation bar
        When I go to a <section> using the navigation bar

        Examples:
            | section   | 
            | Cursos    |
            | Recursos  | 
            | Blog      |
            | Mentoria  |
            | Udemy     |

    @Courses
    Scenario: Courses are presented correctly to potential customers
        When I go to a Cursos using the navigation bar
        And select instruduccion al testing

    @Plans
    Scenario: User can select a plan
        When I select the botton for choose a plan in the page
        Then I can validate the option in the checkout page


    