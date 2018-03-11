package com.parse;

import java.util.List;

import bolts.Task;

/**
 * Created by gal on 3/9/18.
 */

public class ParseSchemaQuery<T extends ParseSchema> extends ParseQuery<T> {
    public ParseSchemaQuery(){
        super("_Schema");
    }

    public ParseSchemaQuery(String className){
        super(className);
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
    Task<T> getFirstAsync(State<T> state, ParseUser user, Task<Void> cancellationToken) {
        return getQueryController().getFirstAsync(state, user, cancellationToken);
    }

    @Override
    Task<List<T>> findAsync(State<T> state, ParseUser user, Task<Void> cancellationToken) {
        return getQueryController().findAsync(state, user, cancellationToken);
    }

    @Override
    Task<Integer> countAsync(State<T> state, ParseUser user, Task<Void> cancellationToken) {
        return getQueryController().countAsync(state, user, cancellationToken);
    }
}
