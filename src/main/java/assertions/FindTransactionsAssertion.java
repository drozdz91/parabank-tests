package assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.MainPage;

public class FindTransactionsAssertion extends MainPage {

    @FindBy(xpath = "//table[@id='transactionTable']")
    private WebElement transactionResultsTable;

    public FindTransactionsAssertion(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void isTableWithTransactionResultsDisplayed() {
        Assert.assertTrue(transactionResultsTable.isDisplayed());
    }
}
