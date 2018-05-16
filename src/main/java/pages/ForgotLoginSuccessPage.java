package pages;

import assertions.ForgotLoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ForgotLoginSuccessPage extends LoggedInPage {

    public ForgotLoginAssertion forgotLoginAssertion;

    public ForgotLoginSuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        forgotLoginAssertion = new ForgotLoginAssertion(driver);
    }
}
