package pages;

import assertions.TransferFundsAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class TransferCompletePage extends LoggedInPage {

    public TransferFundsAssertion transferFundsAssertion;

    public TransferCompletePage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        transferFundsAssertion = new TransferFundsAssertion(driver, getContext());
    }
}
