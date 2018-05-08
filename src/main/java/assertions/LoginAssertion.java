package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class LoginAssertion extends MainPage {

    @FindBy(xpath = "//a[@href='/parabank/logout.htm']")
    private WebElement loginConfirmation;

    @FindBy(xpath = "//p[@class='error']")
    private WebElement errorText;

    public LoginAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isUserLoggedIn() {
        Assert.assertTrue(loginConfirmation.isDisplayed());
    }

    public void getErrorText() {
        Assert.assertEquals(errorText.getText(), "Please enter a username and password.");
    }
}
