package trello.ui.pages.modal;

import core.selenium.util.JsonConverter;
import core.selenium.util.ReadJsonFile;
import org.testng.annotations.Test;
import sun.misc.Cache;
import trello.entities.Context;
import trello.entities.User;
import trello.keys.NamePages;
import trello.ui.PageTransporter;
import trello.ui.pages.BoardPage;
import trello.ui.pages.HomePage;
import trello.ui.pages.LoginPage;

import static org.testng.Assert.*;

public class DueDataModalTest {
    private HomePage homePage;
    private BoardPage boardPage;
    private CardModal cardModal;
    private CheckListModal checkListModal;
    private User user;
    DueDataModal dueDataModal;

    @Test
    public void changeData() {
        user = JsonConverter.jsonToUser(ReadJsonFile.getInstance().getDataByUserType("admin"));
        PageTransporter.navigateToURL(NamePages.getLoginPageUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.login(user);

        homePage = new HomePage();
        homePage.clickOnABoard("TestBoard");

        boardPage = new BoardPage();
        boardPage.selectedCard("TestCard");

        cardModal = new CardModal();
        cardModal.clickDueDateButton();

        dueDataModal =  new DueDataModal();
        dueDataModal.clickMonthButton();
        dueDataModal.setMonth("January");
        dueDataModal.clickYearButton();
        dueDataModal.setYear("2021");
        dueDataModal.setDay("17");

    }


}