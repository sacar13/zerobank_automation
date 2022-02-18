@login
Feature:Login

  Background:
    Given the user at the login page
    When the user hit the sign-in button


  Scenario:log-in with valid credentials
    And the user enters "username" and "password"
    Then the user should be able to login


  Scenario:log-in with in-valid credentials
    And the user enters "user " and "pass "
    Then the user should not be able to login


