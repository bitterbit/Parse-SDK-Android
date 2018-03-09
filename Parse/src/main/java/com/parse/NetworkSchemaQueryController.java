package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by gal on 3/9/18.
 */

public class NetworkSchemaQueryController extends NetworkQueryController {
    public NetworkSchemaQueryController(ParseHttpClient restClient) {
        super(restClient);
    }

    @Override
    /* Package */ <T extends ParseObject> ParseRESTQueryCommand getParseRESTQueryCommand(boolean count, ParseQuery.State<T> state, String sessionToken) {
        if (count){
            return ParseRESTSchemaCommand.countCommand(state, sessionToken);
        } else {
            return ParseRESTSchemaCommand.findCommand(state, sessionToken);
        }
    }

    @Override
    <T extends ParseObject> T fromJson(JSONObject data, String className, ParseQuery.State<T> state) {
        ParseSchema schema = ParseObject.fromJSONWithClass(className, data, ParseDecoder.get());
        schema.setSchemaClassName(extractOriginalClassName(data));
        return (T) schema;
    }

    private String extractOriginalClassName(JSONObject data){
        try {
            return data.getString("className");
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
