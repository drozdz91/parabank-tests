package pages;

import assertions.FindTransactionsAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class FindTransactionsPage extends LoggedInPage {

    public FindTransactionsAssertion findTransactionsAssertion;

    @FindBy(xpath = "//select[@id='accountId']")
    private WebElement selectAnAccount;

    @FindBy(xpath = "//input[@id='criteria.transactionId']")
    private WebElement findByTransactionIdInput;

    @FindBy(xpath = "//button[@value='ID']")
    private WebElement findTransactionsByIdButton;

    @FindBy(xpath = "//input[@id='criteria.onDate']")
    private WebElement findByDateInput;

    @FindBy(xpath = "//button[@value='DATE']")
    private WebElement findTransactionsByDateButton;

    @FindBy(xpath = "//input[@id='criteria.fromDate']")
    private WebElement findByDateRangeFromInput;

    @FindBy(xpath = "//input[@id='criteria.toDate']")
    private WebElement findByDateRangeToInput;

    @FindBy(xpath = "//button[@value='DATE_RANGE']")
    private WebElement findTransactionsByDateRangeButton;

    @FindBy(xpath = "//input[@id='criteria.amount']")
    private WebElement findByAmountInput;

    @FindBy(xpath = "//button[@value='AMOUNT']")
    private WebElement findTransactionsByAmountButton;

    public FindTransactionsPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver,this);
        findTransactionsAssertion = new FindTransactionsAssertion(driver, getContext());
    }

    public FindTransactionsPage selectAnAccount(String account) {
        Select accountId = new Select(selectAnAccount);
        String accountValues = getContextAttribute(account);
        accountId.selectByValue(accountValues);
        return this;
    }

    public FindTransactionsPage fillFindByTransactionId(String findByTransactionId) {
        findByTransactionIdInput.sendKeys(findByTransactionId);
        return this;
    }

    public TransactionResultsPage clickFindTransactionsByIdButton() {
        findTransactionsByIdButton.click();
        waitForJStoLoad();
        return new TransactionResultsPage(driver, getContext());
    }

    public FindTransactionsPage fillFindByDate(String findByDate) {
        findByDateInput.sendKeys(findByDate);
        return this;
    }

    public TransactionResultsPage clickFindTransactionsByDateButton() {
        findTransactionsByDateButton.click();
        waitForJStoLoad();
        return new TransactionResultsPage(driver, getContext());
    }

    public FindTransactionsPage fillFindByDateRangeFrom(String findByDateRangeFrom) {
        findByDateRangeFromInput.sendKeys(findByDateRangeFrom);
        return this;
    }

    public FindTransactionsPage fillFindByDateRangeTo(String findByDateRangeTo) {
        findByDateRangeToInput.sendKeys(findByDateRangeTo);
        return this;
    }

    public TransactionResultsPage clickFindTransactionsByDateRangeButton() {
        findTransactionsByDateRangeButton.click();
        waitForJStoLoad();
        return new TransactionResultsPage(driver, getContext());
    }

    public FindTransactionsPage fillFindByAmount(String findByAmount) {
        findByAmountInput.sendKeys(findByAmount);
        return this;
    }

    public TransactionResultsPage clickFindTransactionsByAmountButton() {
        findTransactionsByAmountButton.click();
        waitForJStoLoad();
        return new TransactionResultsPage(driver, getContext());
    }
}
