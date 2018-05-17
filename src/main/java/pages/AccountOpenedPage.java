package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountOpenedPage extends LoggedInPage {

    public OpenAccountAssertion openAccountAssertion;

    public AccountOpenedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver);
    }
}
