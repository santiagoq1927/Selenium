Feature: client signup

  Scenario: client signup successfully
    Given a client wants to have an account
    When  he send required information to get the account
    Then he should be told that the account was no created