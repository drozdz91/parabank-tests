import org.testng.annotations.Test;
import scenarios.LoginScenario;


public class AccountTest extends MainTest {

    @Test
    public void shouldAddAccount() {
        indexPage.run(new LoginScenario("Mat", "test"))
                .menu.clickOpenNewAccountLink()
                .selectTypeOfAccount("CHECKING")
                .selectAccountToTransfer("13677")
                .clickOpenNewAccountButton()
                .openAccountAssertion.getAccountOpenedConfirmation();
    }
}
