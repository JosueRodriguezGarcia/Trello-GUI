package trello.api.utils;

import core.selenium.util.ReadJsonFile;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import trello.keys.NamePages;

/**
 * This class is used for authentication.
 *
 * @author JosueRodriguez, Andres Burgos
 */
public final class Authentication {

    private static Authentication oauth;
    private RequestSpecification request;

    /**
     * This is constructor that initializes variables.
     */
    private Authentication() {
        //ReadConfiguration reader = ReadConfiguration.getInstance();
        String consumerKey = ReadJsonFile.getInstance("users").getConsumerKey(); //reader.getConsumerKey();
        String consumerSecret = ReadJsonFile.getInstance("users").getConsumerSecret(); //reader.getConsumerSecret();
        String accessToken = ReadJsonFile.getInstance("users").getAccessToken(); //reader.getAccessToken();
        String tokenSecret = ReadJsonFile.getInstance("users").getTokenSecret(); //reader.getTokenSecret();
        String baseUrl = NamePages.getBaseUrl(); //reader.getUrlBase();
        request = new RequestSpecBuilder().setAuth(RestAssured.oauth(consumerKey, consumerSecret,
                accessToken, tokenSecret)).setBaseUri(baseUrl).build();
    }

    /**
     * Gives the class instance according Singleton pattern.
     *
     * @return an instance.
     */
    public static Authentication getInstance() {
        if (oauth == null) {
            oauth = new Authentication();
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
