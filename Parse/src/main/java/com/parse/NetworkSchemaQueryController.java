package com.parse;

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
}
