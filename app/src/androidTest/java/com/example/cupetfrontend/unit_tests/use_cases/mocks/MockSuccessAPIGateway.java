package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MockSuccessAPIGateway {
    public JSONObject createDummySuccessJSON(HashMap<String, String> innerData){
        JSONObject toReturnData = new JSONObject(new HashMap<String, String>(){{
            put("isSuccess", "true");
            put("message", "dummy success message");
        }});

        try {
            toReturnData.put("data", new JSONObject(innerData));
        } catch (JSONException e) {
            throw new InvalidDummyJSONException("Invalid dummy JSON initialization");
        }

        return toReturnData;
    }

    public JSONObject createPetIdSuccessJSON(String[] petIds){
        JSONObject toReturn = createDummySuccessJSON(new HashMap<>());

        try {
            toReturn.getJSONObject("data").put("petIds", new JSONArray(petIds));
        } catch (JSONException e) {
            throw new InvalidDummyJSONException("Invalid pet id dummy JSON initialization");
        }

        return toReturn;
    }
}
