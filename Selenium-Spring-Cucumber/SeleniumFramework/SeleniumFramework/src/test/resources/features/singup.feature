Feature: client sign up

  Scenario: client sign up successfully
    Given a client wants to have an account
    When he sends required information to get the account
    Then he should be told that the account was created