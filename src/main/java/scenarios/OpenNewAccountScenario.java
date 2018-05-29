package scenarios;

import pages.AccountOpenedPage;
import pages.MenuPage;

public class OpenNewAccountScenario implements Scenario<MenuPage, AccountOpenedPage> {

    private String accountType;
    private String accountNumber;

    public OpenNewAccountScenario(String accountType, String accountNumber) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
    }


    @Override
    public AccountOpenedPage run(MenuPage entry) {
        return entry.clickOpenNewAccountLink()
                .selectTypeOfAccount(accountType)
                .selectAccountToTransfer(accountNumber)
                .clickOpenNewAccountButton();
    }
}
