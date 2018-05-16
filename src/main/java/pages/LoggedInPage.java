package pages;

import org.openqa.selenium.WebDriver;

public abstract class LoggedInPage extends MainPage {

    public MenuPage menu;

    public LoggedInPage(WebDriver driver) {
        super(driver);
        this.menu = new MenuPage(driver);
    }
}
