package scenarios;

import pages.AccountPage;
import pages.IndexPage;

public class LoginScenario implements Scenario<IndexPage, AccountPage> {

    private String username;
    private String password;

    public LoginScenario(String username, String password) {
        this.username = username;
        this.password = password;
    }


    @Override
    public AccountPage run(IndexPage entry) {
        return entry.openIndexPage()
                .fillUsername(username)
                .fillPassword(password)
                .clickLoginButton();
    }
}
