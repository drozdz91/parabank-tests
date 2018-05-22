import org.testng.annotations.Test;
import scenarios.LoginScenario;
import scenarios.OpenNewAccountScenario;


public class AccountTest extends MainTest {

    @Test
    public void shouldAddAccount() {
        indexPage.run(new LoginScenario("Mat", "test"))
                .menu.run(new OpenNewAccountScenario("CHECKING", "14010"))
                .openAccountAssertion.getAccountOpenedConfirmation();
    }
}
