package trello.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import trello.ui.PageTransporter;
import trello.ui.pages.LoginPage;
import trello.ui.pages.AuthenticationPage;

public class LoginStep {
    @Given("I go to {string} page")
    public void iGoToPage(String url) {
        PageTransporter.navigateToURL(url);
    }

    @When("I log in as {string} user")
    public void iLogInAsUser(String arg0) {
        LoginPage loginPage = new LoginPage();
        loginPage.fillUsernameField("jrg.test@mailinator.com");
        loginPage.clickLoginButton();
        AuthenticationPage authenticationPage = new AuthenticationPage();
        authenticationPage.fillUsernameField("jrg.test@mailinator.com");
        authenticationPage.continuarButton();
        authenticationPage.fillPasswordField("Control123!");
        authenticationPage.clickLoginButton();

    }
}
