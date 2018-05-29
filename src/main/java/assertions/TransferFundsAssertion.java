package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestContext;
import pages.MainPage;

public class TransferFundsAssertion extends MainPage {

    @FindBy(xpath = "//h1[@class='title' and text()='Transfer Complete!']")
    private WebElement transferCompleteConfirmationText;

    public TransferFundsAssertion(WebDriver driver, ITestContext context) {
        super(driver, context);
        PageFactory.initElements(driver, this);
    }

    public void getTransferCompleteConfrimation() {
        Assert.assertEquals(transferCompleteConfirmationText.getText(), "Transfer Complete!");
    }
}
