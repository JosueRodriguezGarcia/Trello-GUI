package trello.api.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;


public class RestClientAPI {
    private RequestSpecification requestSpecification;

    public RestClientAPI(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }
    public Response get(String endpoint){
        return apiResponse("GET",endpoint);
    }
    public Response put(String endpoint){
        return apiResponse("PUT", endpoint);
    }
    public Response post(String endpoint){
        return apiResponse("POST", endpoint);
    }
    public Response delete(String endpoint){
        return apiResponse("DELETE", endpoint);
    }

    public RequestSpecification getRequest() {
        return requestSpecification;
    }

    public void setRequest(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    private Response apiResponse(String httpMethod, String endpoint){
        return given().
                spec(requestSpecification).
                when().
                request(httpMethod, endpoint);
    }

    public void buildSpec(final Map body){
        String json =  new Gson().toJson(body);
         requestSpecification = given().
                spec(requestSpecification).
                contentType(JSON).
                body(json);

    }
}
