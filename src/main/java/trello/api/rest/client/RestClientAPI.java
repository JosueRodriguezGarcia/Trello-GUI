package trello.api.rest.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import trello.entities.User;
import trello.keys.NamePages;

/**
 * This class is used for authentication.
 *
 * @author JosueRodriguez, Andres Burgos
 */
public final class RestClientAPI {

    private static RestClientAPI oauth;
    private RequestSpecification request;

    /**
     * This is constructor that initializes variables.
     */
    private RestClientAPI() {
        User user = new User();
        String consumerKey = user.getConsumerKey();
        String consumerSecret = user.getConsumerSecret();
        String accessToken = user.getAccessToken();
        String tokenSecret = user.getTokenSecret();
        String baseUrl = NamePages.getBaseUrlAPI();
        request = new RequestSpecBuilder().setAuth(RestAssured.oauth(consumerKey, consumerSecret,
                accessToken, tokenSecret)).setBaseUri(baseUrl).build();
    }

    /**
     * Gives the class instance according Singleton pattern.
     *
     * @return an instance.
     */
    public static RestClientAPI getInstance() {
        if (oauth == null) {
            oauth = new RestClientAPI();
        }
        return oauth;
    }

    /**
     * Gives the request specification resultant of oauth.
     *
     * @return an request specification.
     */
    public RequestSpecification getRequestSpecification() {
        return request;
    }
}