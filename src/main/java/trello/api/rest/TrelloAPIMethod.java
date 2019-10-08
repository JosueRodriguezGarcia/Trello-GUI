package trello.api.rest;

import io.restassured.response.Response;

public final class TrelloAPIMethod {
    private static RestClientAPI request;
    private static Response response;

    public TrelloAPIMethod(){
        request = new RestClientAPI(Authentication.getRequestSpecification("admin"));
    }

    public static String createBoard(final String name){
        String dataBoard = "{ \"name\":\"" + name + "\"}";
//        String dataBoard = "{ \"name\":\""+name+"\"," +
//                             "\"defaultLists\":false}";
        request.buildSpec(dataBoard);
        response = request.post("/boards/");
        return response.getBody().jsonPath().get("id");
    }

    public static String createList(final String name, final String idBoard){
        String dataList = "{ \"name\":\""+name+"\"," +
                             "\"idBoard\":\""+idBoard+"\"}";
        request.buildSpec(dataList);
        response = request.post("/lists");
        return response.getBody().jsonPath().get("id");
    }

    public static String createCard(final String name, final String idList){
        String dataCard = "{ \"name\":\""+name+"\"," +
                             "\"idList\":\""+idList+"\"}";
        request.buildSpec(dataCard);
        response = request.post("/lists");
        return response.getBody().jsonPath().get("id");
    }
}
