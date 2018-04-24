import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.IndexPage;

public class LoginTest {

    WebDriver driver;
    IndexPage indexPage;
    AccountPage accountPage;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void shouldLogin() {
        indexPage.openIndexPage();
        indexPage.fillUsername("Mat7");
        indexPage.fillPassword("test");
        indexPage.clickLoginButton();
        Assert.assertTrue(accountPage.isUserLoggedIn());
    }

    @Test
    public void shouldNotLoginWithoutUsername() {
        indexPage.openIndexPage();
        indexPage.fillUsername("");
        indexPage.fillPassword("test");
        indexPage.clickLoginButton();
        Assert.assertEquals(indexPage.getErrorText(), "Please enter a username and password.");
    }

    @Test
    public void shouldNotLoginWithoutPassword() {
        indexPage.openIndexPage();
        indexPage.fillUsername("Mat7");
        indexPage.fillPassword("");
        indexPage.clickLoginButton();
        Assert.assertEquals(indexPage.getErrorText(), "Please enter a username and password.");
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}
