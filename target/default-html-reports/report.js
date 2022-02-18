$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/PurchaseForeignCurrency.feature");
formatter.feature({
  "name": "Purchase Foreign Currency",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "the user logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.AccountSummaryDefs.the_user_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user click on Pay Bills tab",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayBillsDefs.the_user_click_on_Pay_Bills_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user accesses the Purchase foreign currency cash tab",
  "keyword": "Given "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayBillsDefs.the_user_accesses_the_Purchase_foreign_currency_cash_tab()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Error message for not entering value",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@wip"
    }
  ]
});
formatter.step({
  "name": "user tries to calculate cost without entering a value",
  "keyword": "When "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayBillsDefs.user_tries_to_calculate_cost_without_entering_a_value()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "error message should be displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "com.zerobank.step_definitions.PayBillsDefs.error_message_should_be_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});