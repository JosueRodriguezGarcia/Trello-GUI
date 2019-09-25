package trello.api.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import trello.api.utils.Authentication;

/**
 * RequestManagerAbstract class.
 *
 * @author Josue Rodriguez, Raul Choque
 * @version 0.0.1
 */
public abstract class RequestManagerAbstract {
    private String endPoint;
    private String data;
    private String method;

    /**
     * Created a protected initializeValue to define empty values.
     */
    protected void initializeValue() {
        this.endPoint = "";
        this.data = "";
        this.method = "";
    }

    /**
     * Sets endPoint attribute.
     *
     * @param endPoint is new value for set endPoint attribute.
     */
    public void setEndPoint(final String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Sets data attribute with a new value.
     *
     * @param data is the new value for set data attribute.
     */
    public void setData(final String data) {
        this.data = data;
    }

    /**
     * Gets data attribute of class.
     *
     * @return data attribute.
     */
    public String getData() {
        return data;
    }

    /**
     * Gets method attribute of class.
     *
     * @return method attribute.
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method attribute with a new value.
     *
     * @param method is the new value for set method attribute.
     */
    public void setMethod(final String method) {
        this.method = method;
    }

    /**
     * Gets RequestSpecification with data for authentication.
     *
     * @return a RequestSpecification.
     */
    public RequestSpecification getRequest() {
        return Authentication.getInstance().getRequestSpecification();
    }

    /**
     * Gets endPoint attribute of class.
     *
     * @return endPoint attribute.
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * Makes request and returns its response.
     *
     * @return a Response of a request.
     */
    public abstract Response makeRequest();
}
