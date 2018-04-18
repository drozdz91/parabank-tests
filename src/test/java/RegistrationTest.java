import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void shouldRegisterWithCorrectData() {
        driver.get(baseUrl);
        waitForPageLoad(driver);
        register("Mat", "Dro", "Teczowa", "Koszalin", "zachodniopomorskie",
                "11-111", "12345", "Mat", "test", "test",
                "//input[@class='button' and @value='Register']");
        waitForPageLoad(driver);

        String expectedTitle = "Your account was created successfully. You are now logged in.";
        String actualTitle = driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Test case 1 - shouldRegisterWithCorrectData: PASSED.");
    }

    @Test(priority = 1)
    public void shouldNotRegisterWithTheSameUsername() {
        driver.get(baseUrl);
        waitForPageLoad(driver);
        register("Mat", "Dro", "Teczowa", "Koszalin", "zachodniopomorskie",
                "11-111", "12345", "Mat", "test", "test",
                "//input[@class='button' and @value='Register']");
        waitForPageLoad(driver);

        String expectedTitle = "This username already exists.";
        String actualTitle = driver.findElement(By.xpath("//span[@id='customer.username.errors']")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Test case 2 - shouldNotRegisterWithTheSameUsername: PASSED.");
    }
}
