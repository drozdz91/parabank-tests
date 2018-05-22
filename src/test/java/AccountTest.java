import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;


public class AccountTest extends MainTest {

    private AccountPage accountPage;

    @BeforeMethod
    public void beforeTest() {
        accountPage = indexPage.run(new LoginScenario("Mat", "test"));
    }

    @Test
    public void shouldAddAccount() {
                accountPage.menu.run(new OpenNewAccountScenario("CHECKING", "14010"))
                .openAccountAssertion.getAccountOpenedConfirmation();
    }
}
