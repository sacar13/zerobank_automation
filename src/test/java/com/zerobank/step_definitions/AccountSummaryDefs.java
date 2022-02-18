package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountSummaryDefs {

    LoginPage loginPage = new LoginPage();


    @Given("the user logged in")
    public void the_user_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.signInBtn.click();
        loginPage.login("username","password");
    }

    @Then("page title is {string}")
    public void page_title_is(String title) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("titles are not equal",title,actualTitle);

    }

    @Then("the account types are")
    public void the_account_types_are(List<String> expectedAccountTypes) {
        List<String> actualAccountTypes = BrowserUtils.getElementsText(new AccountSummaryPage().accountTypes);
        Assert.assertEquals("account types are not equal",expectedAccountTypes,actualAccountTypes);
    }

    @Then("Credit Account table columns are")
    public void credit_Account_table_columns_are(List<String> expectedColumnsText) {
        List<String> actualColumnText = BrowserUtils.getElementsText(new AccountSummaryPage().accountTable);
        Assert.assertEquals("Credit Accounts table are not equal",expectedColumnsText,actualColumnText);

    }
}
