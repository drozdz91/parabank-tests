package pages;

import assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

import java.util.List;

public class AccountPage extends LoggedInPage {

    public LoginAssertion loginAssertion;

    @FindBy(xpath = "//table[@id='accountTable']//a")
    private List<WebElement> accountsElements;

    public AccountPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver, getContext());
    }

    public AccountPage getAccountNumber(String accountKeyNumber) {
        String accountValue = accountsElements.get(0).getText();
        setContextAttribute(accountKeyNumber, accountValue);
        return this;
    }
}
