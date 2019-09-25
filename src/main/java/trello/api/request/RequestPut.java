package trello.api.request;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * RequestPut class.
 *
 * @author JosueRodriguez, Raul Choque
 * @version 0.0.1
 */
public class RequestPut extends RequestManagerAbstract {

    /**
     * Call the method initializeValue from RequestManagerAbstract class.
     */
    public RequestPut() {
        super.initializeValue();
    }

    /**
     * Makes a put request and returns its response.
     *
     * @return a Response of a put request.
     */
    public Response makeRequest() {
        return given().
                spec(getRequest()).
                contentType(JSON).
                body(getData()).
                when().
                put(getEndPoint());
    }
}
