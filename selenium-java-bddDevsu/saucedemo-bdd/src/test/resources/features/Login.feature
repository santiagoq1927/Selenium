Feature: Login in Sauce demo

  Background:
    Given a user navigate to login page

  @smoke
  Scenario: Credentials valid
    When the user enter username "standard_user" with the password "secret_sauce" and select login button
    Then show the home page

  @smoke
  Scenario Outline: Credentials invalid
    When the user enter locked username "<username>" with the password "<password>" and select login button
    Then show a error message "<message>"
    Examples:
    |username         |password       |message                                                                   |
    |locked_out_user  |secret_sauce   |Epic sadface: Sorry, this user has been locked out.                       |
    |standard_user    |               |Epic sadface: Password is required                                        |
    |                 |secret_sauce   |Epic sadface: Username is required                                        |
    |invalid          |invalid        |Epic sadface: Username and password do not match any user in this service |
