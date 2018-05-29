package pages;

import assertions.RegisterAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class RegistrationSuccessPage extends LoggedInPage {

    public RegisterAssertion registerAssertion;

    public RegistrationSuccessPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        registerAssertion = new RegisterAssertion(driver, getContext());
    }
}