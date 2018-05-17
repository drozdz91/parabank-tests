package pages;

import assertions.RegisterAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccessPage extends LoggedInPage {

    public RegisterAssertion registerAssertion;

    public RegistrationSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        registerAssertion = new RegisterAssertion(driver);
    }
}