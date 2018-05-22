package pages;

import assertions.TransferFundsAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TransferCompletePage extends LoggedInPage {

    public TransferFundsAssertion transferFundsAssertion;

    public TransferCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        transferFundsAssertion = new TransferFundsAssertion(driver);
    }
}
