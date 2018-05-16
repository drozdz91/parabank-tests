package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends MainPage {

    @FindBy(xpath = "//a[contains(@href, '/parabank/overview.htm') and text()='Accounts Overview']")
    private WebElement accountsOverviewLink;

    @FindBy(xpath = "//a[contains(@href, '/parabank/openaccount.htm') and text()='Open New Account']")
    private WebElement openNewAccountLink;

    public MenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public AccountPage clickAccountsOverview() {
        accountsOverviewLink.click();
        waitForJStoLoad();
        return new AccountPage(driver);
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        openNewAccountLink.click();
        waitForJStoLoad();
        return new OpenNewAccountPage(driver);
    }
}
