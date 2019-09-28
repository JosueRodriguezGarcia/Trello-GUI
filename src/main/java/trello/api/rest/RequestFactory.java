package trello.api.rest;

import io.restassured.response.Response;
import trello.api.rest.response.*;

import java.util.HashMap;
import java.util.Map;

public class RequestFactory {
    private static Map<String, RequestManager> requestMap = new HashMap<>();
    static {
        requestMap.put("GET", new RequestGet());
        requestMap.put("PUT", new RequestPut());
        requestMap.put("POST", new RequestPost());
        requestMap.put("DELETE", new RequestDelete());
    }
    public static RequestManager getRequest(final String method){
        return requestMap.get(method.toUpperCase());
    }
}
