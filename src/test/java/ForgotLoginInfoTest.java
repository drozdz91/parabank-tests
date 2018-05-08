import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotLoginInfoTest extends MainTest {

    @Test
    public void shouldFindLoginInfo() {
        customerLookupPage.openCustomerLookupPage();
        customerLookupPage.fillFirstName("Mat");
        customerLookupPage.fillLastName("Dro");
        customerLookupPage.fillAddress("Teczowa");
        customerLookupPage.fillCity("Koszalin");
        customerLookupPage.fillState("zachodniopomorskie");
        customerLookupPage.fillZipCode("11-111");
        customerLookupPage.fillSSN("12345");
        customerLookupPage.clickMyLoginInfoButton();
        Assert.assertEquals(forgotLoginSuccessPage.getFoundLoginInfoConfirmationText(),
                "Your login information was located successfully. You are now logged in.");
    }

    @Test
    public void shouldNotFindLoginInfoWithoutFirstName() {
        customerLookupPage.openCustomerLookupPage();
        customerLookupPage.fillFirstName("");
        customerLookupPage.fillLastName("Dro");
        customerLookupPage.fillAddress("Teczowa");
        customerLookupPage.fillCity("Koszalin");
        customerLookupPage.fillState("zachodniopomorskie");
        customerLookupPage.fillZipCode("11-111");
        customerLookupPage.fillSSN("12345");
        customerLookupPage.clickMyLoginInfoButton();
        Assert.assertEquals(customerLookupPage.getErrorWithoutFirstNameText(),
                "First name is required.");
    }

    @Test
    public void shouldNotFindLoginInfoWithoutLastName() {
        customerLookupPage.openCustomerLookupPage();
        customerLookupPage.fillFirstName("Mat");
        customerLookupPage.fillLastName("");
        customerLookupPage.fillAddress("Teczowa");
        customerLookupPage.fillCity("Koszalin");
        customerLookupPage.fillState("zachodniopomorskie");
        customerLookupPage.fillZipCode("11-111");
        customerLookupPage.fillSSN("12345");
        customerLookupPage.clickMyLoginInfoButton();
        Assert.assertEquals(customerLookupPage.getErrorWithoutLastNameText(),
                "Last name is required.");
    }
}
