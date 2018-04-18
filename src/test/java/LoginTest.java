import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
