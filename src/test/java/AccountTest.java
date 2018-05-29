import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;


public class AccountTest extends MainTest {

    private final String ACCOUNT_TYPE = "CHECKING";
    private final String ACCOUNT_KEY = "accountKeyNumber";
    private AccountPage accountPage;

    @BeforeMethod
    @Parameters({"login", "password"})
    public void prepare(String login, String password) {
        accountPage = indexPage.run(new LoginScenario(login, password));
    }

    @Test
    public void shouldAddAccount() {
        accountPage.getAccountNumber(ACCOUNT_KEY)
                .menu.run(new OpenNewAccountScenario(ACCOUNT_TYPE, ACCOUNT_KEY))
                .openAccountAssertion.getAccountOpenedConfirmation();
    }
}
