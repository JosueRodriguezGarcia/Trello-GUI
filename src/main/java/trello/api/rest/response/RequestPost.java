package trello.api.rest.response;

import io.restassured.response.Response;
import trello.api.rest.RequestManager;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class RequestPost extends RequestManager {
    public RequestPost(){
        super.initializes();
    }
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                contentType(JSON).
                body(getData()).
                when().
                post(getEndpoint());
    }
}
