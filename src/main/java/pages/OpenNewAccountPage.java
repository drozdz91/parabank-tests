package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends LoggedInPage {

    public OpenAccountAssertion openAccountAssertion;

    @FindBy(xpath = "//select[@id='type']")
    private WebElement selectAccountType;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement selectAccountToTransferFunds;

    @FindBy(xpath = "//input[@class='button' and @value='Open New Account']")
    private WebElement openNewAccountButton;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver);
    }

    public OpenNewAccountPage selectTypeOfAccount(String type) {
        Select accountType = new Select(selectAccountType);
        accountType.selectByValue(type);
        return this;
    }

    public OpenNewAccountPage selectAccountToTransfer(String account) {
        Select accountToTransfer = new Select(selectAccountToTransferFunds);
        accountToTransfer.selectByValue(account);
        return this;
    }

    public AccountOpenedPage clickOpenNewAccountButton() {
        openNewAccountButton.click();
        waitForJStoLoad();
        return new AccountOpenedPage(driver);
    }
}
