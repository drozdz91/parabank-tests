import org.testng.annotations.Test;

public class ForgotLoginInfoTest extends MainTest {

    @Test
    public void shouldFindLoginInfo() {
        indexPage.openIndexPage()
                .clickForgotLoginInfoLink()
                .fillFirstName("Mat")
                .fillLastName("Dro")
                .fillAddress("Teczowa")
                .fillCity("Koszalin")
                .fillState("zachodniopomorskie")
                .fillZipCode("11-111")
                .fillSSN("12345")
                .clickMyLoginInfoButton()
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
