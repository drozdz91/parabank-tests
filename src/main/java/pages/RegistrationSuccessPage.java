package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationSuccessPage extends MainPage {

    public RegistrationSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getRegisterConfirmationText() {
        return driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText();
    }
}
