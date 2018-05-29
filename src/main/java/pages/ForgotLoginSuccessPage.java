package pages;

import assertions.ForgotLoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class ForgotLoginSuccessPage extends LoggedInPage {

    public ForgotLoginAssertion forgotLoginAssertion;

    public ForgotLoginSuccessPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        forgotLoginAssertion = new ForgotLoginAssertion(driver, getContext());
    }
}
