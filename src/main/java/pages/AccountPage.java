package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends MainPage {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.xpath("//a[@href='/parabank/logout.htm']")).isDisplayed();
    }

    public String getRegisterConfirmationText() {
        return driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
    }

    public String getFoundLoginInfoConfirmationText() {
        return driver.findElement(By.xpath("//div[@id='rightPanel']/p[1]")).getText();
    }
}
