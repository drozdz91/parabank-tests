package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class IndexPage extends MainPage {

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public void openIndexPage() {
        driver.get("http://parabank.parasoft.com/");
    }

    public void fillUsername(String username) {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    }

    public void fillPassword(String password) {
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@class='button' and @value='Log In']")).sendKeys(Keys.ENTER);
    }

    public String getErrorText() {
        return driver.findElement(By.xpath("//p[@class='error']")).getText();
    }
}
