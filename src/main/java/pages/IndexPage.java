package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IndexPage extends MainPage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openIndexPage() {
        driver.get("http://parabank.parasoft.com/");
        waitForJStoLoad();
    }

    public void fillUsername(String userName) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
    }

    public void fillPassword(String password) {
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@class='button' and @value='Log In']")).click();
        waitForJStoLoad();
    }

    public String getErrorText() {
        return driver.findElement(By.xpath("//p[@class='error']")).getText();
    }
}
