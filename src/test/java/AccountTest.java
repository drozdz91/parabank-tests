import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;

public class AccountTest extends MainTest {


    private AccountPage start;

    @BeforeMethod
    public void beforeTest() {
        start = indexPage.run(new LoginScenario("Mat", "test"));
    }

    @Test
    public void shouldAddAccount() {
        start.menu.clickOpenNewAccountLink()
                .clickOpenNewAccountButton()
                .openAccountAssertion.getAccountOpenedConfirmation();
    }
}
