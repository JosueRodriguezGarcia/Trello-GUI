package trello.api;

import trello.api.rest.Authentication;
import trello.api.rest.RestClientAPI;
import trello.api.rest.TrelloAPIMethod;

public final class EnvironmentSetup {

    private static EnvironmentSetup environmentSetup;
    private static RestClientAPI request;
    private String idBoard;
    private String idListTasks1;
    private String idListTasks2;

    private EnvironmentSetup(){

    }

    public static EnvironmentSetup getInstance() {
        if (environmentSetup == null) {
            environmentSetup = new EnvironmentSetup();
        }
        return environmentSetup;
    }

    public void setEnvironmentSetup(){
        idBoard = TrelloAPIMethod.createBoard("TestBoard");

        idListTasks1 = TrelloAPIMethod.createList("Tasks1",idBoard);
        TrelloAPIMethod.createList("Tasks2",idBoard);
        TrelloAPIMethod.createList("TestList",idBoard);

        TrelloAPIMethod.createCard("Card2", idListTasks1);
        TrelloAPIMethod.createCard("Card1", idListTasks1);
        TrelloAPIMethod.createCard("Card3", idListTasks1);
        TrelloAPIMethod.createCard("Card0", idListTasks1);
    }

    public void delete(){
        String endPoint = "/boards/".concat(idBoard);
        request.delete(endPoint);
    }
}
