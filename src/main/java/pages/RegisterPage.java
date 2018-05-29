package pages;

import assertions.RegisterAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;

public class RegisterPage extends MainPage {

    public RegisterAssertion registerAssertion;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    private WebElement ssnInput;

    @FindBy(xpath = "//input[@id='customer.username']")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[@id='customer.password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    private WebElement confirmationPasswordInput;

    @FindBy(xpath = "//input[@class='button' and @value='Register']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
        registerAssertion = new RegisterAssertion(driver, getContext());
    }

    public RegisterPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public RegisterPage fillAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public RegisterPage fillCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public RegisterPage fillState(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    public RegisterPage fillZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public RegisterPage fillSSN(String ssn) {
        ssnInput.sendKeys(ssn);
        return this;
    }

    public RegisterPage fillUsername(String username) {
        userNameInput.sendKeys(username);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public RegisterPage fillConfirmationPassword(String confirmPassword) {
        confirmationPasswordInput.sendKeys(confirmPassword);
        return this;
    }

    public RegistrationSuccessPage clickRegisterButton() {
        registerButton.click();
        waitForJStoLoad();
        return new RegistrationSuccessPage(driver, getContext());
    }
}
