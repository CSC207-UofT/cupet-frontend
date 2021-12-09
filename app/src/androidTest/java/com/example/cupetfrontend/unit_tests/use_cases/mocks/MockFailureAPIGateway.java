package com.example.cupetfrontend.unit_tests.use_cases.mocks;

import org.json.JSONObject;

import java.util.HashMap;

public class MockFailureAPIGateway {
    public JSONObject createDummyFailResponse() {
        return new JSONObject(new HashMap<String, String>() {{
            put("isSuccess", "false");
            put("message", "dummy error message");
        }});
    }
}
