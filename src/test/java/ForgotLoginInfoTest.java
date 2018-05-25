import org.testng.annotations.Test;
import scenarios.ForgotLoginScenario;

public class ForgotLoginInfoTest extends MainTest {

    private final String firstName = "Mat";
    private final String lastName = "Dro";
    private final String address = "Teczowa";
    private final String city = "Koszalin";
    private final String state = "zachodniopomorskie";
    private final String zipCode = "11-111";
    private final String ssn = "12345";

    @Test
    public void shouldFindLoginInfo() {
        indexPage.run(new ForgotLoginScenario(firstName, lastName, address, city, state, zipCode, ssn))
                .forgotLoginAssertion.getFoundLoginInfoConfirmationText();
    }

    @Test
    public void shouldNotFindLoginInfoWithoutFirstName() {
        indexPage.openIndexPage()
                .clickForgotLoginInfoLink()
                .fillFirstName("")
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
                .clickMyLoginInfoButton()
                .forgotLoginAssertion.getErrorWithoutFirstNameText();
    }

    @Test
    public void shouldNotFindLoginInfoWithoutLastName() {
        indexPage.openIndexPage()
                .clickForgotLoginInfoLink()
                .fillFirstName(firstName)
                .fillLastName("")
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
                .clickMyLoginInfoButton()
                .forgotLoginAssertion.getErrorWithoutLastNameText();
    }
}
