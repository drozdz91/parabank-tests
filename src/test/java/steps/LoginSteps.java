package steps;

import assertions.LoginAssertion;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends MainSteps {

    public LoginSteps() {
        super();
    }

    @Given("^System displays login page$")
    public void systemDisplaysLoginPage() throws Throwable {
        indexPage.openIndexPage();
    }

    @When("^User fills username as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void usernameAsWithPassword(String userName, String password) throws Throwable {
        indexPage.fillUsername(userName)
                .fillPassword(password)
                .clickLoginButton();
    }

    @Then("^User is logged in$")
    public void userIsLoggedIn() throws Throwable {
        new LoginAssertion(driver, context).isUserLoggedIn();
    }

    @Then("^User is not logged in$")
    public void userIsNotLoggedIn() throws Throwable {
        new LoginAssertion(driver, context).getErrorText();
    }
}
