@paybills
Feature: Pay Bills page


  Background:
    Given the user logged in
    When the user click on Pay Bills tab

  Scenario: the user should be able to go to Pay Bills page
    Then page title is "Zero - Pay Bills"


  Scenario: Successful payment operation
    When the user choose Payee type
    And the user choose Account type
    And the user fill out the Amount as "250"
    And the user selects the date as "2022-02-22"
    And the user types the description as "A successful payment"
    And the user hits the Pay button
    Then the user should see the "The payment was successfully submitted."


  Scenario: Unsuccessful payment operation with not fill in the blanks
    When the user choose Payee type
    And the user choose Account type
    And the user doesn't fill out the Amount
    And the user types the description as "A unsuccessful payment"
    And the user hits the Pay button
    Then the user should get the "Please fill out this field."


  Scenario: Unsuccessful payment operation with wrong inputs
    When the user choose Payee type
    And the user choose Account type
    And the user fill out the Amount as "abc*/"
    And the user enters the date as "def"
    And the user types the description as "A unsuccessful payment"
    And the user hits the Pay button
    Then the user should see the "The payment was successfully submitted."







