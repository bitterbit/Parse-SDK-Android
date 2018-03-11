package com.parse;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by gal on 3/9/18.
 */

@ParseClassName("_Schema")
public class ParseSchema extends ParseObject {

    private String schemaClassName = "";

    protected ParseSchema(){
    }

    void setSchemaClassName(String className){
        this.schemaClassName = className;
    }

    public String getClassName(){
        return schemaClassName;
    }

    public Map<String, ParseField.FieldType> getFields(){
        Map<String, ParseField.FieldType> fields = new HashMap<>();

        JSONObject object = getJSONObject("fields");

        Iterator<?> keys = object.keys();

        while( keys.hasNext() ) {
            String key = (String)keys.next();
            ParseField.FieldType type = getFieldType(object, key);
            fields.put(key, type);
        }

        return fields;
    }

    public JSONObject getCLP(){
        // TODO: implement Class Level Permissions Class
        return getJSONObject("classLevelPermissions");
    }

    private ParseField.FieldType getFieldType(JSONObject jsonFields, String key){
        try {
            JSONObject fieldMeta = jsonFields.getJSONObject(key);
            String type = fieldMeta.getString("type");
            return ParseField.fromString(type);
        } catch (JSONException e) {
            e.printStackTrace();
            return ParseField.FieldType.None;
        }
    }
}
