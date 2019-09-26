package trello.api.rest;

/**
 * FactoryRequest class.
 *
 * @author Josue Rodriguez, Raul Choque
 * @version 0.0.1
 */
public final class FactoryRequest {
    public static final String MESSAGE_FOR_UNKNOWN_METHOD = "Unknown method type";

    /**
     * This method constructor initializes variables.
     */
    private FactoryRequest() {
    }

    /**
     * Creates an instance specific of RequestManagerAbstract.
     *
     * @param method is for validate the type of RequestManagerAbstract.
     * @return an instance RequestManagerAbstract.
     */
    public static RequestManagerAbstract getRequest(String method) {
        String nameMethod = method.toUpperCase();
        RequestMethod requestMethod = RequestMethod.valueOf(nameMethod);
        switch (requestMethod) {
            case POST:
                return new RequestPost();
            case GET:
                return new RequestGet();
            case PUT:
                return new RequestPut();
            case DELETE:
                return new RequestDelete();
            default:
                throw new RuntimeException(MESSAGE_FOR_UNKNOWN_METHOD);
        }
    }
}
