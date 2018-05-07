package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotLoginSuccessPage extends MainPage {

    public ForgotLoginSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getFoundLoginInfoConfirmationText() {
        return driver.findElement(By.xpath("//div[@id='rightPanel']/p[1]")).getText();
    }
}
