package pages;

import assertions.FindTransactionsAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TransactionResultsPage extends LoggedInPage {

    public FindTransactionsAssertion findTransactionsAssertion;

    public TransactionResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        findTransactionsAssertion = new FindTransactionsAssertion(driver);
    }
}
