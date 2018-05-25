package scenarios;

import pages.MenuPage;
import pages.TransferCompletePage;

public class TransferFundsScenario implements Scenario<MenuPage, TransferCompletePage> {

    private String amount;

    public TransferFundsScenario(String amount) {
        this.amount = amount;
    }


    @Override
    public TransferCompletePage run(MenuPage entry) {
        return entry.clickTransferFundsLink()
                .inputAmountOfDollarsToTransfer(amount)
                .selectFromAccount()
                .selectToAccount()
                .clickTransferButton();
    }
}
