@activity
Feature: Account activity page

  Background:
    Given the user logged in
    When the user click on Account activity tab

  Scenario: User should be able to see title
    Then page title is "Zero - Account Activity"

  Scenario:  Account drop down default option should be Savings
    Then the user should be able to see default option as "Savings"
    Then the user should see the dropdown options as
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: User should see Transaction headers title
    Then the user should see Transaction column names as
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |




