import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.TransferCompletePage;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;
import scenarios.TransferFundsScenario;

public class FindTransactionsTest extends MainTest {

    private final String accountType = "CHECKING";
    private final String amountOfDollars = "1000";
    private TransferCompletePage transferCompletePage;

    @BeforeMethod
    @Parameters({"login", "password"})
    public void prepare(String login, String password) {
        transferCompletePage = indexPage.run(new LoginScenario(login, password))
                .menu.run(new OpenNewAccountScenario(accountType))
                .menu.run(new TransferFundsScenario(amountOfDollars));
    }

    @Test
    public void shouldFindTransactionById() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount()
                .fillFindByTransactionId("14698")
                .clickFindTransactionsByIdButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }

    @Test
    public void shouldFindTransactionByDate() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount()
                .fillFindByDate("05-25-2018")
                .clickFindTransactionsByDateButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }

    @Test
    public void shouldFindTransactionByDateRange() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount()
                .fillFindByDateRangeFrom("05-20-2018")
                .fillFindByDateRangeTo("05-25-2018")
                .clickFindTransactionsByDateRangeButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }

    @Test
    public void shouldFindTransactionByAmount() {
        transferCompletePage.menu.clickFindTransactionsLink()
                .selectAnAccount()
                .fillFindByAmount("100")
                .clickFindTransactionsByAmountButton()
                .findTransactionsAssertion.isTableWithTransactionResultsDisplayed();
    }
}
