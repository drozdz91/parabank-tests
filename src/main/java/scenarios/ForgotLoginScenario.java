package scenarios;

import pages.ForgotLoginSuccessPage;
import pages.IndexPage;

public class ForgotLoginScenario implements Scenario<IndexPage, ForgotLoginSuccessPage> {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String ssn;

    public ForgotLoginScenario(String firstName, String lastName, String address, String city, String state,
                               String zipCode, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.ssn = ssn;
    }


    @Override
    public ForgotLoginSuccessPage run(IndexPage entry) {
        return entry.openIndexPage()
                .clickForgotLoginInfoLink()
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillAddress(address)
                .fillCity(city)
                .fillState(state)
                .fillZipCode(zipCode)
                .fillSSN(ssn)
                .clickMyLoginInfoButton();
    }
}
