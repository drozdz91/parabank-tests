package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class RegisterAssertion extends MainPage {

    @FindBy(xpath = "//div[@id='rightPanel']/p")
    private WebElement registrationConfirmationText;

    @FindBy(xpath = "//span[@id='customer.username.errors']")
    private WebElement errorTheSameUsernameText;

    @FindBy(xpath = "//span[@id='customer.username.errors']")
    private WebElement errorWithoutUsernameText;

    @FindBy(xpath = "//span[@id='repeatedPassword.errors']")
    private WebElement errorWrongConfirmationPasswordText;

    public RegisterAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getRegisterConfirmationText() {
        Assert.assertEquals(registrationConfirmationText.getText(),
                "Your account was created successfully. You are now logged in.");
    }

    public void getErrorTheSameUsernameText() {
        Assert.assertEquals(errorTheSameUsernameText.getText(), "This username already exists.");
    }

    public void getErrorWithoutUsernameText() {
        Assert.assertEquals(errorWithoutUsernameText.getText(), "Username is required.");
    }

    public void getErrorWrongConfirmationPasswordText() {
        Assert.assertEquals(errorWrongConfirmationPasswordText.getText(), "Passwords did not match.");
    }
}
