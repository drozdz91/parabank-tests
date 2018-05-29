import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TransferCompletePage;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;
import scenarios.TransferFundsScenario;

public class FindTransactionsTest extends MainTest {

    private final String ACCOUNT_TYPE = "CHECKING";
    private final String ACCOUNT_KEY = "accountKeyNumber";
    private final String NEW_ACCOUNT_KEY = "newAccountKeyNumber";
    private final String amountOfDollars = "1000";
    private TransferCompletePage transferCompletePage;

    @BeforeMethod
    @Parameters({"login", "password"})
    public void prepare(String login, String password) {
        transferCompletePage = indexPage.run(new LoginScenario(login, password))
                .getAccountNumber(ACCOUNT_KEY)
                .menu.run(new OpenNewAccountScenario(ACCOUNT_TYPE, ACCOUNT_KEY))
                .getNewAccountNumber(NEW_ACCOUNT_KEY)
                .menu.run(new TransferFundsScenario(amountOfDollars, ACCOUNT_KEY, NEW_ACCOUNT_KEY));
    }

    @Test
    public void shouldFindTransactionById() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount(NEW_ACCOUNT_KEY)
                .fillFindByTransactionId("14698")
                .clickFindTransactionsByIdButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }

    @Test
    public void shouldFindTransactionByDate() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount(NEW_ACCOUNT_KEY)
                .fillFindByDate("05-29-2018")
                .clickFindTransactionsByDateButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }

    @Test
    public void shouldFindTransactionByDateRange() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount(NEW_ACCOUNT_KEY)
                .fillFindByDateRangeFrom("05-20-2018")
                .fillFindByDateRangeTo("05-29-2018")
                .clickFindTransactionsByDateRangeButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }

    @Test
    public void shouldFindTransactionByAmount() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount(NEW_ACCOUNT_KEY)
                .fillFindByAmount("1000")
                .clickFindTransactionsByAmountButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }
}
