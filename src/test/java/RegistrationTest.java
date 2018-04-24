import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.RegisterPage;

public class RegistrationTest {

    WebDriver driver;
    RegisterPage registerPage;
    AccountPage accountPage;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        registerPage = new RegisterPage(driver);
        accountPage = new AccountPage(driver);
    }

    @Test
    public void shouldRegister() {
        registerPage.openRegisterPage();
        registerPage.fillFirstName("Mat4");
        registerPage.fillLastName("Dro");
        registerPage.fillAddress("Teczowa");
        registerPage.fillCity("Koszalin");
        registerPage.fillState("zachodniopomorskie");
        registerPage.fillZipCode("11-111");
        registerPage.fillSSN("12345");
        registerPage.fillUserName("Mat4");
        registerPage.fillPassword("test");
        registerPage.fillConfirmationPassword("test");
        registerPage.clickRegisterButton();
        Assert.assertEquals(accountPage.getRegisterConfirmationText(), "Your account was created successfully. " +
                "You are now logged in.");
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}
