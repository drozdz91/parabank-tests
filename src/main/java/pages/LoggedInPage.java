package pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public abstract class LoggedInPage extends MainPage {

    public MenuPage menu;

    public LoggedInPage(WebDriver driver, ITestContext context) {
        super(driver, context);
        this.menu = new MenuPage(driver, context);
    }
}
