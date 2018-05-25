package scenarios;

import pages.AccountOpenedPage;
import pages.MenuPage;

public class OpenNewAccountScenario implements Scenario<MenuPage, AccountOpenedPage> {

    private String accountType;

    public OpenNewAccountScenario(String accountType) {
        this.accountType = accountType;
    }


    @Override
    public AccountOpenedPage run(MenuPage entry) {
        return entry.clickOpenNewAccountLink()
                .selectTypeOfAccount(accountType)
                .selectAccountToTransfer()
                .clickOpenNewAccountButton();
    }
}
