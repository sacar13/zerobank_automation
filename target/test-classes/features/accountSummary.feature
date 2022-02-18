@summary
Feature: Account summary page

  Background:
    Given the user logged in
    Then page title is "Zero - Account Summary"


  Scenario: Account types
    Then the account types are
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table
    Then Credit Account table columns are
      | Account     |
      | Credit Card |
      | Balance     |