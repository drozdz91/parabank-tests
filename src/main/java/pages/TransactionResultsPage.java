package pages;

import assertions.FindTransactionsAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class TransactionResultsPage extends LoggedInPage {

    public FindTransactionsAssertion findTransactionsAssertion;

    public TransactionResultsPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        findTransactionsAssertion = new FindTransactionsAssertion(driver, getContext());
    }
}
