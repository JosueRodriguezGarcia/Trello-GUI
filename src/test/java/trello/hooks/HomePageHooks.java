package trello.hooks;

import cucumber.api.java.After;
import trello.entities.Context;
import trello.ui.pages.HomePage;

public class HomePageHooks {
    private Context context;
    private HomePage homePage;

    public HomePageHooks(final Context context) {
        this.context = context;
        this.homePage = context.getHomePage();
    }

    @After("@LogOut")
    public void logOut() {
        homePage.logOut();
    }
}
