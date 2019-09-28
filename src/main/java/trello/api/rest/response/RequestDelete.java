package trello.api.rest.response;

import io.restassured.response.Response;
import trello.api.rest.RequestManager;

import static io.restassured.RestAssured.given;

public class RequestDelete extends RequestManager {
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                when().
                delete(getEndpoint());
    }
}
