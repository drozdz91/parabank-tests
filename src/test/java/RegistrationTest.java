import org.testng.annotations.Test;
import scenarios.RegisterScenario;

public class RegistrationTest extends MainTest {

    @Test
    public void shouldRegister() {
        indexPage.run(new RegisterScenario("Mat", "Dro", "Teczowa", "Koszalin",
                "zachodniopomorskie", "11-111", "12345", "Mat", "test",
                "test"))
                .registerAssertion.getRegisterConfirmationText();
    }

    @Test(priority = 1)
    public void shouldNotRegisterWithTheSameUsername() {
        indexPage.openIndexPage()
                .clickRegisterLink()
                .fillFirstName("Mat")
                .fillLastName("Dro")
                .fillAddress("Teczowa")
                .fillCity("Koszalin")
                .fillState("zachodniopomorskie")
                .fillZipCode("11-111")
                .fillSSN("12345")
                .fillUsername("Mat")
                .fillPassword("test")
                .fillConfirmationPassword("test")
                .clickRegisterButton()
                .registerAssertion.getErrorTheSameUsernameText();
    }

    @Test(priority = 2)
    public void shouldNotRegisterWithoutUsername() {
        indexPage.openIndexPage()
                .clickRegisterLink()
                .fillFirstName("Mat")
                .fillLastName("Dro")
                .fillAddress("Teczowa")
                .fillCity("Koszalin")
                .fillState("zachodniopomorskie")
                .fillZipCode("11-111")
                .fillSSN("12345")
                .fillUsername("")
                .fillPassword("test")
                .fillConfirmationPassword("test")
                .clickRegisterButton()
                .registerAssertion.getErrorWithoutUsernameText();
    }

    @Test(priority = 3)
    public void shouldNotRegisterWithWrongConfirmPassword() {
        indexPage.openIndexPage()
                .clickRegisterLink()
                .fillFirstName("Mat")
                .fillLastName("Dro")
                .fillAddress("Teczowa")
                .fillCity("Koszalin")
                .fillState("zachodniopomorskie")
                .fillZipCode("11-111")
                .fillSSN("12345")
                .fillUsername("Mat")
                .fillPassword("test")
                .fillConfirmationPassword("te")
                .clickRegisterButton()
                .registerAssertion.getErrorWrongConfirmationPasswordText();
    }
}
