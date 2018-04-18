import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver = new ChromeDriver();
    public String baseUrl = "http://parabank.parasoft.com/";

    public void waitForPageLoad(WebDriver webDriver) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(webDriver1 -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
    }

    public void login(String userName, String password, String logInButton) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath(logInButton)).sendKeys(Keys.ENTER);
    }

    public void logout(String logOut) {
        driver.findElement(By.xpath(logOut)).sendKeys(Keys.ENTER);
    }

    @Test
    public void shouldLoginWithCorrectData() {
        driver.get(baseUrl);
        waitForPageLoad(driver);
        login("Mat", "test", "//input[@class='button' and @value='Log In']");
        waitForPageLoad(driver);

        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']")).isDisplayed());
        logout("//a[@href='/parabank/logout.htm']");
    }

    @Test (priority = 1)
    public void shouldNotLoginWithoutUsername() {
        driver.get(baseUrl);
        waitForPageLoad(driver);
        login("", "test", "//input[@class='button' and @value='Log In']");
        waitForPageLoad(driver);

        String expectedTitle = "Please enter a username and password.";
        String actualTitle = driver.findElement(By.xpath("//p[@class='error']")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
