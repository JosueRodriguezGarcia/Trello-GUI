package trello.api.rest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

/**
 * RequestDelete class.
 *
 * @author Josue Rodriguez, Raul Choque
 * @version 0.0.1
 */
public class RequestDelete extends RequestManagerAbstract {

    /**
     * Call the method initializeValue from RequestManagerAbstract class.
     */
    public RequestDelete() {
        super.initializeValue();
    }

    /**
     * Makes a delete request and returns its response.
     *
     * @return a Response of a delete request.
     */
    public Response makeRequest() {
        return given().
                spec(super.getRequest()).
                when().
                delete(super.getEndPoint());
    }
}
