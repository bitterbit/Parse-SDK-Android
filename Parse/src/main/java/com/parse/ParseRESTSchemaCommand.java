package com.parse;

import com.parse.http.ParseHttpRequest;

import java.util.Map;

/**
 * Created by gal on 3/9/18.
 */

public class ParseRESTSchemaCommand extends ParseRESTQueryCommand {

    public static <T extends ParseObject> ParseRESTSchemaCommand findCommand(ParseQuery.State<T> state, String sessionToken){
        Map <String, String> parameters = encode(state, false);
        return new ParseRESTSchemaCommand("schemas/", ParseHttpRequest.Method.GET, parameters, sessionToken);
    }

    private ParseRESTSchemaCommand(String httpPath, ParseHttpRequest.Method httpMethod, Map<String, ?> parameters, String sessionToken) {
        super(httpPath, httpMethod, parameters, sessionToken);
    }
}
