package scenarios;

import pages.IndexPage;
import pages.RegistrationSuccessPage;

public class RegisterScenario implements Scenario<IndexPage, RegistrationSuccessPage> {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String ssn;
    private String username;
    private String password;
    private String confirmationPassword;

    public RegisterScenario(String firstName, String lastName, String address, String city, String state,
                            String zipCode, String ssn, String username, String password, String confirmationPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
        this.confirmationPassword = confirmationPassword;
    }


    @Override
    public RegistrationSuccessPage run(IndexPage entry) {
        return entry.openIndexPage()
                .clickRegisterLink()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
                .fillUsername(username)
                .fillPassword(password)
                .fillConfirmationPassword(confirmationPassword)
                .clickRegisterButton();
    }
}
