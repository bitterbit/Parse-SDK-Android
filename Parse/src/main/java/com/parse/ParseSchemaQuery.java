package com.parse;

import java.util.List;

import bolts.Task;

/**
 * Created by gal on 3/9/18.
 */

public class ParseSchemaQuery extends ParseQuery<ParseSchema> {
    public ParseSchemaQuery(){
        super("_Schema");
    }

    private static NetworkQueryController queryController;

    private static NetworkQueryController getQueryController(){
        if (queryController != null){
            return queryController;
        }
        queryController = new NetworkSchemaQueryController(ParsePlugins.get().restClient());
        return queryController;
    }

    @Override
    Task<ParseSchema> getFirstAsync(State<ParseSchema> state, ParseUser user, Task<Void> cancellationToken) {
        return getQueryController().getFirstAsync(state, user, cancellationToken);
    }

    @Override
    Task<List<ParseSchema>> findAsync(State<ParseSchema> state, ParseUser user, Task<Void> cancellationToken) {
        return getQueryController().findAsync(state, user, cancellationToken);
    }

    @Override
    Task<Integer> countAsync(State<ParseSchema> state, ParseUser user, Task<Void> cancellationToken) {
        return getQueryController().countAsync(state, user, cancellationToken);
    }
}
