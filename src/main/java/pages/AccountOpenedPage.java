package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class AccountOpenedPage extends LoggedInPage {

    public OpenAccountAssertion openAccountAssertion;

    @FindBy(xpath = "//a[@id='newAccountId']")
    private WebElement newAccountId;

    public AccountOpenedPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver, getContext());
    }

    public AccountOpenedPage getNewAccountNumber(String newAccountKeyNumber) {
        String accountValue = newAccountId.getText();
        setContextAttribute(newAccountKeyNumber, accountValue);
        return this;
    }
}
