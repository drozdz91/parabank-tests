package pages;

import assertions.OpenAccountAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountPage extends LoggedInPage {

    public OpenAccountAssertion openAccountAssertion;

    @FindBy(xpath = "//input[@class='button' and @value='Open New Account']")
    private WebElement openNewAccountButton;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAccountAssertion = new OpenAccountAssertion(driver);
    }

    public AccountOpenedPage clickOpenNewAccountButton() {
        openNewAccountButton.click();
        waitForJStoLoad();
        return new AccountOpenedPage(driver);
    }
}
