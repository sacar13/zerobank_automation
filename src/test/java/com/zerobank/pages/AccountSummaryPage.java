package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//div[@class='board-content'])[3]//th")
    public List<WebElement> accountTable;

    @FindBy(linkText = "Savings")
    public WebElement savingElement;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerageElement;

    @FindBy(linkText = "Checking")
    public WebElement checkingElement;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCardElement;

    @FindBy(xpath = "(//a[@style='text-decoration: underline'])[6]")
    public WebElement loanElement;




}
