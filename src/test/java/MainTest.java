import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class MainTest {

    WebDriver driver;
    IndexPage indexPage;

    RegisterPage registerPage;
    RegistrationSuccessPage registrationSuccessPage;

    CustomerLookupPage customerLookupPage;
    ForgotLoginSuccessPage forgotLoginSuccessPage;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        indexPage = new IndexPage(driver);

        registerPage = new RegisterPage(driver);
        registrationSuccessPage = new RegistrationSuccessPage(driver);

        customerLookupPage = new CustomerLookupPage(driver);
        forgotLoginSuccessPage = new ForgotLoginSuccessPage(driver);
    }

    @AfterMethod
    public void after() {
        driver.close();
    }
}
