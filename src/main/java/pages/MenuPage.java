package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MainPage {

    @FindBy(xpath = "//a[contains(@href, '/parabank/openaccount.htm') and text()='Open New Account']")
    private WebElement openNewAccountLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/overview.htm') and text()='Accounts Overview']")
    private WebElement accountsOverviewLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/transfer.htm') and text()='Transfer Funds']")
    private WebElement transferFundsLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/billpay.htm') and text()='Bill Pay']")
    private WebElement billPayLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/findtrans.htm') and text()='Find Transactions']")
    private WebElement findTransactionsLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/updateprofile.htm') and text()='Update Contact Info']")
    private WebElement updateContactInfoLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/requestloan.htm') and text()='Request Loan']")
    private WebElement requestLoanLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/logout.htm') and text()='Log Out']")
    private WebElement logOutLink;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        openNewAccountLink.click();
        waitForJStoLoad();
        return new OpenNewAccountPage(driver);
    }

    public AccountPage clickAccountsOverviewLink() {
        accountsOverviewLink.click();
        waitForJStoLoad();
        return new AccountPage(driver);
    }

    public TransferFundsPage clickTransferFundsLink() {
        transferFundsLink.click();
        waitForJStoLoad();
        return new TransferFundsPage(driver);
    }

    public IndexPage clickLogOutLink() {
        logOutLink.click();
        waitForJStoLoad();
        return new IndexPage(driver);
    }
}
