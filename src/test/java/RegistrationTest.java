import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationTest {
    public WebDriver driver = new ChromeDriver();
    public String baseUrl = "http://parabank.parasoft.com/parabank/register.htm";

    public void waitForPageLoad(WebDriver webDriver) {
        Wait<WebDriver> wait = new WebDriverWait(webDriver, 30);
        wait.until(webDriver1 -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState"));
    }

    public void register(String firstName, String lastName, String street, String city, String state,
                         String zipCode, String ssn, String userName, String password, String confirmPassword,
                         String registerButton) {
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(street);
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys(ssn);
        driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys(confirmPassword);
        driver.findElement(By.xpath(registerButton)).click();
    }
}
