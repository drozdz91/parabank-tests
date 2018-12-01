package steps;

import assertions.RegisterAssertion;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.RegisterPage;

public class RegisterSteps extends MainSteps {

    public RegisterPage registerPage;

    public RegisterSteps() {
        super();
        registerPage = new RegisterPage(driver, context);
    }

    @Given("^System displays register page$")
    public void systemDisplaysRegisterPage() throws Throwable {
        indexPage.openIndexPage()
                .clickRegisterLink();
    }

    @When("^User fills first name as \"([^\"]*)\"$")
    public void userFillsFirstNameAs(String firstName) throws Throwable {
        registerPage.fillFirstName(firstName);
    }

    @And("^User fills last name as \"([^\"]*)\"$")
    public void userFillsLastNameAs(String lastName) throws Throwable {
        registerPage.fillLastName(lastName);
    }

    @And("^User fills address as \"([^\"]*)\"$")
    public void userFillsAddressAs(String address) throws Throwable {
        registerPage.fillAddress(address);
    }

    @And("^User fills city as \"([^\"]*)\"$")
    public void userFillsCityAs(String city) throws Throwable {
        registerPage.fillCity(city);
    }

    @And("^User fills state as \"([^\"]*)\"$")
    public void userFillsStateAs(String state) throws Throwable {
        registerPage.fillState(state);
    }

    @And("^User fills zip code as \"([^\"]*)\"$")
    public void userFillsZipCodeAs(String zipCode) throws Throwable {
        registerPage.fillZipCode(zipCode);
    }

    @And("^User fills ssn as \"([^\"]*)\"$")
    public void userFillsSsnAs(String ssn) throws Throwable {
        registerPage.fillSSN(ssn);
    }

    @And("^User fills username as \"([^\"]*)\"$")
    public void userFillsUsernameAs(String userName) throws Throwable {
        registerPage.fillUsername(userName);
    }

    @And("^User fills password as \"([^\"]*)\"$")
    public void userFillsPasswordAs(String password) throws Throwable {
        registerPage.fillPassword(password);
    }

    @And("^User fills confirmation password as \"([^\"]*)\"$")
    public void userFillsConfirmationPasswordAs(String confirmationPassword) throws Throwable {
        registerPage.fillConfirmationPassword(confirmationPassword);
    }

    @And("^User clicks REGISTER button$")
    public void userClicksREGISTERButton() {
        registerPage.clickRegisterButton();
    }

    @Then("^User is registered in application$")
    public void userIsRegisteredInApplication() throws Throwable {
        new RegisterAssertion(driver, context).getRegisterConfirmationText();
    }
}
