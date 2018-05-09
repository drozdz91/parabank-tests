package pages;

import assertions.ForgotLoginAssertion;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLookupPage extends MainPage {

    public ForgotLoginAssertion forgotLoginAssertion;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='address.street']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@id='address.city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='address.state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//input[@id='ssn']")
    private WebElement ssnInput;

    @FindBy(xpath = "//input[@class='button' and @value='Find My Login Info']")
    private WebElement findMyLoginInfoButton;

    public CustomerLookupPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        forgotLoginAssertion = new ForgotLoginAssertion(driver);
    }

    public CustomerLookupPage fillFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public CustomerLookupPage fillLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public CustomerLookupPage fillAddress(String address) {
        addressInput.sendKeys(address);
        return this;
    }

    public CustomerLookupPage fillCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public CustomerLookupPage fillState(String state) {
        stateInput.sendKeys(state);
        return this;
    }

    public CustomerLookupPage fillZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
        return this;
    }

    public CustomerLookupPage fillSSN(String ssn) {
        ssnInput.sendKeys(ssn);
        return this;
    }

    public ForgotLoginSuccessPage clickMyLoginInfoButton() {
        findMyLoginInfoButton.click();
        waitForJStoLoad();
        return new ForgotLoginSuccessPage(driver);
    }
}
