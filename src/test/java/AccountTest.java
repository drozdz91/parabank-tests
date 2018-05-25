import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;


public class AccountTest extends MainTest {

    private final String accountType = "CHECKING";
    private AccountPage accountPage;

    @BeforeMethod
    @Parameters({"login", "password"})
    public void prepare(String login, String password) {
        accountPage = indexPage.run(new LoginScenario(login, password));
    }

    @Test
    public void shouldAddAccount() {
        accountPage.menu.run(new OpenNewAccountScenario(accountType))
                .openAccountAssertion.getAccountOpenedConfirmation();
    }
}
