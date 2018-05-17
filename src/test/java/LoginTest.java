import org.testng.annotations.Test;
import scenarios.LoginScenario;

public class LoginTest extends MainTest {

    @Test
    public void shouldLogin() {
        indexPage.run(new LoginScenario("Mat", "test"))
                .loginAssertion.isUserLoggedIn();
    }

    @Test
    public void shouldNotLoginWithoutUsername() {
        indexPage.openIndexPage()
                .fillUsername("")
                .fillPassword("test")
                .clickLoginButton()
                .loginAssertion.getErrorText();
    }

    @Test
    public void shouldNotLoginWithoutPassword() {
        indexPage.openIndexPage()
                .fillUsername("Mat")
                .fillPassword("")
                .clickLoginButton()
                .loginAssertion.getErrorText();
    }
}
