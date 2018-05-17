package scenarios;

import pages.AccountOpenedPage;
import pages.MenuPage;

public class OpenNewAccountScenario implements Scenario<MenuPage, AccountOpenedPage> {

    private String accountType;
    private String fromAccountId;

    public OpenNewAccountScenario(String accountType, String fromAccountId) {
        this.accountType = accountType;
        this.fromAccountId = fromAccountId;
    }

    @Override
    public AccountOpenedPage run(MenuPage entry) {
        return entry.clickOpenNewAccountLink()
                .selectTypeOfAccount(accountType)
                .selectAccountToTransfer(fromAccountId)
                .clickOpenNewAccountButton();
    }
}
