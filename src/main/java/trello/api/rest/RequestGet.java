package trello.api.rest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * RequestGet class.
 *
 * @author Josue Rodriguez, Raul Choque.
 * @version 0.0.1
 */
public class RequestGet extends RequestManagerAbstract {

    /**
     * Call the method initializeValue from RequestManagerAbstract class.
     */
    public RequestGet() {
        super.initializeValue();
    }

    /**
     * Makes a get request and returns its response.
     *
     * @return a Response of a get request.
     */
    public Response makeRequest() {
        return given().
                spec(super.getRequest()).
                when().
                get(super.getEndPoint());
    }
}
