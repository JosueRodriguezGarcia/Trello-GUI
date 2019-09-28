package trello.api.rest;

import io.restassured.internal.ResponseParserRegistrar;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class RequestManager {
    private String endpoint;
    private String data;
    private String method;

    public void initializes(){
        this.endpoint = "";
        this.data = "";
        this.method = "";
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public RequestSpecification getRequest() {
        return RestClientAPI.getInstance().getRequestSpecification();
    }

    public abstract Response makeRequest();
}
