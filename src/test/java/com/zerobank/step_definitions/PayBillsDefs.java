package com.zerobank.step_definitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class PayBillsDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("the user click on Pay Bills tab")
    public void the_user_click_on_Pay_Bills_tab() {
        new PayBillsPage().payBillsElement.click();
       // new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @When("the user choose Payee type")
    public void the_user_choose_Payee_type() {
        Select select = new Select(payBillsPage.payeeElement);
        select.selectByValue("apple");
    }

    @When("the user choose Account type")
    public void the_user_choose_Account_type() {
        Select select = new Select(payBillsPage.accountElement);
        select.selectByVisibleText("Loan");
    }

    @When("the user fill out the Amount as {string}")
    public void the_user_fill_out_the_Amount_as(String amount) {
        payBillsPage.amountElement.sendKeys(amount);
    }

    @When("the user selects the date as {string}")
    public void the_user_selects_the_date_as(String date) {
        payBillsPage.dateElement.sendKeys(date);
    }

    @When("the user types the description as {string}")
    public void the_user_types_the_description_as(String description) {
        payBillsPage.descElement.sendKeys(description);

    }

    @When("the user hits the Pay button")
    public void the_user_hits_the_Pay_button() {
        payBillsPage.payBtn.click();
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @Then("the user should see the {string}")
    public void the_user_should_see_the(String expectedSubmitMsg) {
        String actualSubmitMsg = payBillsPage.submitMsgElement.getText();
        Assert.assertEquals("the messages are not equal", expectedSubmitMsg, actualSubmitMsg);
    }

    @When("the user doesn't fill out the Amount")
    public void the_user_doesn_t_fill_out_the_Amount() {
        payBillsPage.amountElement.sendKeys("");
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @Then("the user should get the {string}")
    public void the_user_should_get_the(String expectedValidationMessage) {
        String actualValidationMessage = payBillsPage.amountElement.getAttribute("validationMessage");
        Assert.assertEquals("the validation messages are not equal", expectedValidationMessage, actualValidationMessage);
    }

    @When("the user enters the date as {string}")
    public void the_user_enters_the_date_as(String string) throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();

        String text = "Hello";
        //google find JS code and paste here and arrange
        jse.executeScript("arguments[0].setAttribute('value', '" + text + "')", payBillsPage.dateElement);
        Thread.sleep(5000);

    }

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.addNewPayeeElement.click();
        new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> info) {
        Actions actions = new Actions(Driver.get());
        actions.click(payBillsPage.payeeNameInBox)
                .sendKeys(info.get("Payee Name"), Keys.TAB)
                .sendKeys(info.get("Payee Address"), Keys.TAB)
                .sendKeys(info.get("Account"), Keys.TAB)
                .sendKeys(info.get("Payee details"), Keys.TAB)
                .sendKeys(Keys.ENTER).build().perform();

//        payBillsPage.payeeNameInBox.sendKeys(info.get("Payee Name"));
//        payBillsPage.payeeAddressInBox.sendKeys(info.get("Payee Address"));
//        payBillsPage.accountInBox.sendKeys(info.get("Account"));
//        payBillsPage.payeeDetailsInBox.sendKeys(info.get("Payee details"));
//        payBillsPage.payeeAddBtn.click();

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage = payBillsPage.payeeMsgTxtElement.getText();
        Assert.assertEquals("the messages are not equal", expectedMessage, actualMessage);
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        payBillsPage.purchaseForeignElement.click();
        //new DashboardPage().waitUntilLoaderScreenDisappear();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedOptions) {
        Select select = new Select(payBillsPage.currencyElement);
        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());
        actualOptions.remove("Select One");
        Assert.assertEquals("currency options are not equal",expectedOptions,actualOptions);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.calculateCostElement.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = alert.getText();
        System.out.println(alertMessage);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

         new Select(payBillsPage.currencyElement).selectByIndex(5);
         payBillsPage.calculateCostElement.click();
    }





}
