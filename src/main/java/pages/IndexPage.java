package pages;

import assertions.LoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage extends MainPage {

    private String url;
    public LoginAssertion loginAssertion;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@class='button' and @value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href, 'register.htm') and text()='Register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[contains(@href, 'lookup.htm') and text()='Forgot login info?']")
    private WebElement forgotLoginInfoLink;

    public IndexPage(WebDriver driver, String url) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver);
        this.url = url;
    }

    public IndexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        loginAssertion = new LoginAssertion(driver);
    }

    public IndexPage openIndexPage() {
        driver.get(url);
        waitForJStoLoad();
        return this;
    }

    public IndexPage fillUsername(String userName) {
        userNameInput.sendKeys(userName);
        return this;
    }

    public IndexPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        waitForJStoLoad();
        return new AccountPage(driver);
    }

    public RegisterPage clickRegisterLink() {
        registerLink.click();
        waitForJStoLoad();
        return new RegisterPage(driver);
    }

    public CustomerLookupPage clickForgotLoginInfoLink() {
        forgotLoginInfoLink.click();
        waitForJStoLoad();
        return new CustomerLookupPage(driver);
    }
}
