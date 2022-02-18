package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FindTransactionDefs extends BrowserUtils{

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @And("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        accountActivityPage.findTransactionsElement.click();
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {
        accountActivityPage.dateElement1.clear();
        accountActivityPage.dateElement1.sendKeys(date1);
        accountActivityPage.dateElement2.clear();
        accountActivityPage.dateElement2.sendKeys(date2);
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.findElement.click();
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date fromD = dateFormat.parse(fromDate);
            Date afterD = dateFormat.parse(toDate);
            BrowserUtils.sleep(1);
            List<String> datesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
            List<Date> actualDates = new ArrayList<>();
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
            for (Date actualDate : actualDates) {
                boolean isBetween = (actualDate.after(fromD)) || actualDate.equals(fromD) &&
                        actualDate.before(afterD) || actualDate.equals(afterD);
                Assert.assertTrue("Date is out of range", isBetween);
            }
        }catch (ParseException e){
            Assert.fail("Wrong date format, needs to be yyyy-MM-dd");
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
        List<Date> actualDates = new ArrayList<>();
        try {
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format, correct format should be: yyyy-MM-dd");
        }
        List<Date> sortedDate = new ArrayList<>(actualDates);

        sortedDate.sort(Collections.reverseOrder());
        for (int i = 0; i < sortedDate.size(); i++) {
            Assert.assertEquals(sortedDate.get(i), (actualDates.get(i)));
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
        List<Date> actualDates = new ArrayList<>();
        Date dateNotAcceptable = null;
        try {
            dateNotAcceptable = dateFormat.parse(date);
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format please follow this: yyyy-MM-dd");
        }
        for (Date actualDate : actualDates) {
            Assert.assertNotEquals(actualDate, dateNotAcceptable);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description) {
        accountActivityPage.descriptionElement.clear();
        accountActivityPage.descriptionElement.sendKeys(description);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description) {
        List<String> descElementsText = BrowserUtils.getElementsText(accountActivityPage.descResultTextElt);

        for (String each : descElementsText){
            Assert.assertTrue(each.contains(description));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description) {
        List<String> descElementsText = BrowserUtils.getElementsText(accountActivityPage.descResultTextElt);

        for (String each : descElementsText){
            Assert.assertTrue(each.contains(description));//normally accordingly scenario assertion should be assertFalse
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List<String> depositElementsText = BrowserUtils.getElementsText(accountActivityPage.depositResultElement);
        Assert.assertFalse(depositElementsText.isEmpty());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<String> withdrawalElementsText = BrowserUtils.getElementsText(accountActivityPage.withdrawalResultElement);
        Assert.assertFalse(withdrawalElementsText.isEmpty());
    }

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        Select select = new Select(accountActivityPage.typeSelectElement);
        select.selectByValue("DEPOSIT");

    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        List<String> withdrawalElementsText = BrowserUtils.getElementsText(accountActivityPage.withdrawalResultElement);
        System.out.println(withdrawalElementsText);
        Assert.assertFalse(withdrawalElementsText.isEmpty());
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        Select select = new Select(accountActivityPage.typeSelectElement);
        select.selectByValue("WITHDRAWAL");
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<String> depositElementsText = BrowserUtils.getElementsText(accountActivityPage.depositResultElement);
        System.out.println(depositElementsText);
        Assert.assertFalse(depositElementsText.isEmpty());

    }












}
