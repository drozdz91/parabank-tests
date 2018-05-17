import org.testng.annotations.Test;
import scenarios.ForgotLoginScenario;

public class ForgotLoginInfoTest extends MainTest {

    @Test
    public void shouldFindLoginInfo() {
        indexPage.run(new ForgotLoginScenario("Mat", "Dro", "Teczowa", "Koszalin",
                "zachodniopomorskie", "11-111", "12345"))
                .forgotLoginAssertion.getFoundLoginInfoConfirmationText();
    }

    @Test
    public void shouldNotFindLoginInfoWithoutFirstName() {
        indexPage.openIndexPage()
                .clickForgotLoginInfoLink()
                .fillFirstName("")
                .fillLastName("Dro")
                .fillAddress("Teczowa")
                .fillCity("Koszalin")
                .fillState("zachodniopomorskie")
                .fillZipCode("11-111")
                .fillSSN("12345")
                .clickMyLoginInfoButton()
                .forgotLoginAssertion.getErrorWithoutFirstNameText();
    }

    @Test
    public void shouldNotFindLoginInfoWithoutLastName() {
        indexPage.openIndexPage()
                .clickForgotLoginInfoLink()
                .fillFirstName("Mat")
                .fillLastName("")
                .fillAddress("Teczowa")
                .fillCity("Koszalin")
                .fillState("zachodniopomorskie")
                .fillZipCode("11-111")
                .fillSSN("12345")
                .clickMyLoginInfoButton()
                .forgotLoginAssertion.getErrorWithoutLastNameText();
    }
}
