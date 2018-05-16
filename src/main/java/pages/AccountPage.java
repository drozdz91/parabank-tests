package pages;

import assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends LoggedInPage {

    public LoginAssertion loginAssertion;

    /*@FindBy(xpath = "//a[contains(@href, '/parabank/openaccount.htm') and text()='Open New Account']")
    private WebElement openNewAccountLink;*/

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver);
    }

    /*public OpenNewAccountPage clickOpenNewAccountLink() {
        openNewAccountLink.click();
        waitForJStoLoad();
        return new OpenNewAccountPage(driver);
    }*/
}
