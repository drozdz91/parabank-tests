package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class ForgotLoginAssertion extends MainPage {

    @FindBy(xpath = "//div[@id='rightPanel']/p[1]")
    private WebElement foundLoginInfoConfirmationText;

    @FindBy(xpath = "//span[@id='firstName.errors']")
    private WebElement errorWithoutFirstNameText;

    @FindBy(xpath = "//span[@id='lastName.errors']")
    private WebElement errorWithoutLastNameText;

    public ForgotLoginAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getFoundLoginInfoConfirmationText() {
        Assert.assertEquals(foundLoginInfoConfirmationText.getText(),
                "Your login information was located successfully. You are now logged in.");
    }

    public void getErrorWithoutFirstNameText() {
        Assert.assertEquals(errorWithoutFirstNameText.getText(), "First name is required.");
    }

    public void getErrorWithoutLastNameText() {
        Assert.assertEquals(errorWithoutLastNameText.getText(), "Last name is required.");
    }
}
