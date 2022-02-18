package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(linkText = "Account Activity")
    public WebElement accountActivityTab;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountDropdownElement;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionTableElement;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactionsElement;

    @FindBy(xpath = "//input[@class='hasDatepicker'][1]")
    public WebElement dateElement1;

    @FindBy(xpath = "//input[@class='hasDatepicker'][2]")
    public WebElement dateElement2;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findElement;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover']//tbody)[2]/tr")
    public WebElement dateTextElement;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tbody/tr/td[1]")
    public List<WebElement> allDates;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement descriptionElement;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr//td[2]")
    public List<WebElement> descResultTextElt;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr//td[3]")
    public List<WebElement> depositResultElement;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]//tr//td[4]")
    public List<WebElement> withdrawalResultElement;

    @FindBy(css = "select[id='aa_type']")
    public WebElement typeSelectElement;






}
