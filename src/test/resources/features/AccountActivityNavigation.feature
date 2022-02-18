@accountActivityNav
Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user logged in

  Scenario: Savings account redirect
    When the user clicks on Savings link on the Account Summary page
    Then page title is "Zero - Account Activity"
    Then the user should be able to see default option as "Savings"

  Scenario: Brokerage account redirect
    When the user clicks on Brokerage link on the Account Summary page
    Then page title is "Zero - Account Activity"
    Then the user should be able to see default option as "Brokerage"

  Scenario: Checking account redirect
    When the user clicks on Checking link on the Account Summary page
    Then page title is "Zero - Account Activity"
    Then the user should be able to see default option as "Checking"

  Scenario: Credit Card account redirect
    When the user clicks on Credit card link on the Account Summary page
    Then page title is "Zero - Account Activity"
    Then the user should be able to see default option as "Credit Card"

  Scenario: Loan account redirect
    When the user clicks on Loan link on the Account Summary page
    Then page title is "Zero - Account Activity"
    Then the user should be able to see default option as "Loan"

