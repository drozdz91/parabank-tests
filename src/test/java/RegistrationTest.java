import org.testng.annotations.Test;
import scenarios.RegisterScenario;

public class RegistrationTest extends MainTest {

    private final String firstName = "Mat";
    private final String lastName = "Dro";
    private final String address = "Teczowa";
    private final String city = "Koszalin";
    private final String state = "zachodniopomorskie";
    private final String zipCode = "11-111";
    private final String ssn = "12345";

    @Test
    public void shouldRegister() {
        indexPage.run(new RegisterScenario(firstName, lastName, address, city, state, zipCode, ssn, "Mat",
                "test", "test"))
                .registerAssertion.getRegisterConfirmationText();
    }

    @Test(priority = 1)
    public void shouldNotRegisterWithTheSameUsername() {
        indexPage.openIndexPage()
                .clickRegisterLink()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
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
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
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
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
                .fillUsername("Mat")
                .fillPassword("test")
                .fillConfirmationPassword("te")
                .clickRegisterButton()
                .registerAssertion.getErrorWrongConfirmationPasswordText();
    }
}
