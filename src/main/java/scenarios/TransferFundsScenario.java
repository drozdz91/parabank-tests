package scenarios;

import pages.MenuPage;
import pages.TransferCompletePage;

public class TransferFundsScenario implements Scenario<MenuPage, TransferCompletePage> {

    private String amount;
    private String fromAccount;
    private String toAccount;

    public TransferFundsScenario(String amount, String fromAccount, String toAccount) {
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }


    @Override
    public TransferCompletePage run(MenuPage entry) {
        return entry.clickTransferFundsLink()
                .inputAmountOfDollarsToTransfer(amount)
                .selectFromAccount(fromAccount)
                .selectToAccount(toAccount)
                .clickTransferButton();
    }
}
