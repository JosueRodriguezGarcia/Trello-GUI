package trello.api.rest.response;

import io.restassured.response.Response;
import trello.api.rest.RequestManager;
import trello.api.rest.RestClientAPI;

import static io.restassured.RestAssured.given;

/**
 * RequestGet class.
 * @author Josue Rodriguez Garcia.
 * @version 0.0.1
 */
public class RequestGet extends RequestManager {

    /**
     * dcscsdcdscscds.
     * @return an Response.
     */
    @Override
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                when().
                get(getEndpoint());
    }
}
