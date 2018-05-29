package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

public class OpenNewAccountPage extends LoggedInPage {

    public OpenAccountAssertion openAccountAssertion;

    @FindBy(xpath = "//select[@id='type']")
    private WebElement selectAccountType;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement selectAccountToTransferFunds;

    @FindBy(xpath = "//input[@class='button' and @value='Open New Account']")
    private WebElement openNewAccountButton;

    public OpenNewAccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver,  getContext());
    }

    public OpenNewAccountPage selectTypeOfAccount(String type) {
        Select accountType = new Select(selectAccountType);
        accountType.selectByValue(type);
        return this;
    }

    public OpenNewAccountPage selectAccountToTransfer(String accountTransferTo) {
        Select accountToTransfer = new Select(selectAccountToTransferFunds);
        String value = getContextAttribute(accountTransferTo);
        accountToTransfer.selectByValue(value);
        return this;
    }

    public AccountOpenedPage clickOpenNewAccountButton() {
        openNewAccountButton.click();
        waitForJStoLoad();
        return new AccountOpenedPage(driver, getContext());
    }
}
