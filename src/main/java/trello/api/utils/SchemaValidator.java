package trello.api.utils;

import core.utils.Log;
import io.restassured.response.Response;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class validates the schema of a request response.
 *
 * @author Josue Rodriguez
 * @version 0.0.1
 */
public final class SchemaValidator {
    /**
     * This method constructor initializes the variables.
     */
    public SchemaValidator() {
    }

    /**
     * This method validates the right schemaJson of the response for a request.
     *
     * @param response   The response parameter defines the input response obtained for a request.
     * @param schemaName The schemaJson parameter defines the input schemaJson obtained of a "<File>.json"
     * @return a boolean that represent the response validation.
     */
    public boolean validator(final Response response, final String schemaName) {
        InputStream inputStream = null;
        try  {
            inputStream = getClass().getClassLoader().getResourceAsStream("schema/" + schemaName.concat("Schema.json"));
            JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
            Schema schema = SchemaLoader.load(jsonObject);
            schema.validate(new JSONObject(response.jsonPath().getMap("$")));
            Log.getInstance().getLogger().info("Validation Passed " + jsonObject);
            return true;
        } catch (ValidationException ex) {
            Log.getInstance().getLogger().info(ex);
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Log.getInstance().getLogger().info("Validation Failed " + e);
                    e.printStackTrace();
                }
            }
        }
    }
}
