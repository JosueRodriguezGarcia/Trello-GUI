package trello.api.rest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RequestManagerTest {

    @Test
    public void testPostBoard() {
        RequestManager requestManager;
        Response response;
        String endPoint = "boards";
        String method = "post";
        String name = "New Board";
        String data = "{ \"name\":\"" + name + "\"}";
        requestManager = RequestFactory.getRequest(method);
        requestManager.setEndpoint(endPoint);
        requestManager.setMethod(method);
        requestManager.setData(data);
        response = requestManager.makeRequest();
        Assert.assertEquals(response.jsonPath().get("name"), name);

    }

}