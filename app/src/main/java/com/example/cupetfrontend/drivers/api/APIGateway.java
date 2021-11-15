package com.example.cupetfrontend.drivers.api;

import java.util.HashMap;
import java.util.Map;

/**
 * A superclass responsible for making API requests.
 */
public class APIGateway {
    /**
     * Given a user's session token, create an authentication header.
     *
     * @param token The user's session token
     * @return An authentication header for a request
     */
    public Map<String, String> createAuthHeaders(String token){
        return new HashMap<String, String>() {{
            put("Authorization", "Bearer " + token);
        }};
    }
}
