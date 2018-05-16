package scenarios;

import pages.AccountOpenedPage;
import pages.AccountPage;
import pages.MenuPage;

public class OpenNewAccountScenario implements Scenario<MenuPage, AccountOpenedPage> {

    @Override
    public AccountOpenedPage run(MenuPage entry) {
        return entry.clickOpenNewAccountLink()
                .clickOpenNewAccountButton();
    }
}
