package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user at the login page")
    public void the_user_at_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user hit the sign-in button")
    public void the_user_hit_the_sign_in_button() {
        loginPage.signInBtn.click();
    }

    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String username, String password) {
        loginPage.login(username,password);

    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("titles are not equal","Zero - Account Summary",actualTitle);
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {
        Driver.get().navigate().back();
        String errorTextMsg = loginPage.errorText.getText();
        Assert.assertEquals("messages are not equal",errorTextMsg,"Login and/or password are wrong.");
    }
}
