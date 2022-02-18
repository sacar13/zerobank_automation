package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class PayBillsPage extends BasePage{

    @FindBy(linkText = "Pay Bills")
    public WebElement payBillsElement;

    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement payeeElement;

    @FindBy(xpath = "//select[@id='sp_account']")
    public WebElement accountElement;

    @FindBy(xpath = "//input[@id='sp_amount']")
    public WebElement amountElement;

    @FindBy(xpath = "//input[@id='sp_description']")
    public WebElement descElement;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    public WebElement submitMsgElement;

    @FindBy(xpath = "//input[@id='sp_date']")
    public WebElement dateElement;

    @FindBy(id = "pay_saved_payees")
    public WebElement payBtn;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayeeElement;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeNameInBox;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddressInBox;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement accountInBox;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetailsInBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement payeeAddBtn;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement payeeMsgTxtElement;

    @FindBy(xpath = "//li[@class='ui-state-default ui-corner-top'][2]")
    public WebElement purchaseForeignElement;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement currencyElement;

    @FindBy(xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculateCostElement;


}
