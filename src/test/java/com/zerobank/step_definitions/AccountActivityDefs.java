package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("the user click on Account activity tab")
    public void the_user_click_on_Account_activity_tab() {
        new AccountActivityPage().accountActivityTab.click();
    }

    @Then("the user should be able to see default option as {string}")
    public void the_user_should_be_able_to_see_default_option_as(String expectedDefaultOption) {
        Select accountDropdown = new Select(accountActivityPage.accountDropdownElement);
        String actualDropdownOption = accountDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals("default option is not equal",expectedDefaultOption,actualDropdownOption);
    }

    @Then("the user should see the dropdown options as")
    public void the_user_should_see_the_dropdown_options_as(List<String> expectedDropdownOptions) {
        Select accountDropdown = new Select(accountActivityPage.accountDropdownElement);
        List<String> actualDropdownOptions = BrowserUtils.getElementsText(accountDropdown.getOptions());

        Assert.assertEquals("dropdown options are not equal",expectedDropdownOptions,actualDropdownOptions);
    }

    @Then("the user should see Transaction column names as")
    public void the_user_should_see_Transaction_column_names_as(List<String> expectedTransactionsTable) {

        new DashboardPage().waitUntilLoaderScreenDisappear();
        List<String> actualTransactionsTable = BrowserUtils.getElementsText(new AccountActivityPage().transactionTableElement);
        Assert.assertEquals("Transactions table column names are not equal",expectedTransactionsTable,actualTransactionsTable);
    }




}
