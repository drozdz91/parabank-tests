import org.testng.annotations.Test;

public class LoginTest extends MainTest {

    @Test
    public void shouldLogin() {
        indexPage.openIndexPage()
                .fillUsername("Mat")
                .fillPassword("test")
                .clickLoginButton()
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
