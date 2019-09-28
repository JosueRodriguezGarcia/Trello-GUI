package trello.api.rest;

import core.selenium.util.JsonConverter;
import core.selenium.util.ReadJsonFile;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import trello.entities.User;
import trello.keys.NamePages;

/**
 * This class is used for authentication.
 *
 * @author Josue Rodriguez
 */
public final class RestClientAPI {

    private static RestClientAPI oauth;
    private RequestSpecification request;

    /**
     * This is constructor that initializes variables.
     */
    private RestClientAPI() {
        User user = JsonConverter.jsonToUser(ReadJsonFile.getInstance().getDataByUserType("admin"));
//        "consumerKey": "b8172176637075376d6f3fa6da4c33c6",
//                "consumerSecret": "6be522fdaf553f92d7a8ef6f275295c8eda8b64ea9b9771e0bc0471c10efcc55",
//                "accessToken": "f77dcce84606a39e0ddbca303dfb92371b28fd3d10b3942597dfd43c18332e3f",
//                "tokenSecret": "f77dcce84606a39e0ddbca303dfb92371b28fd3d10b3942597dfd43c18332e3f"
        String consumerKey = "b8172176637075376d6f3fa6da4c33c6";//user.getConsumerKey();
        String consumerSecret = "6be522fdaf553f92d7a8ef6f275295c8eda8b64ea9b9771e0bc0471c10efcc55";//user.getConsumerSecret();
        String accessToken = "f77dcce84606a39e0ddbca303dfb92371b28fd3d10b3942597dfd43c18332e3f";//user.getAccessToken();
        String tokenSecret = "f77dcce84606a39e0ddbca303dfb92371b28fd3d10b3942597dfd43c18332e3f";//user.getTokenSecret();
        String baseUrl = "https://api.trello.com/1/";//NamePages.getBaseUrlAPI();
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