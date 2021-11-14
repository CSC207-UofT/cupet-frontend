package com.example.cupetfrontend.controllers.abstracts;

import com.example.cupetfrontend.controllers.InvalidJWTException;
import org.json.JSONObject;

public interface IJWTParser {
    /**
     * Parse a JSON Web token and return the payload inside as a JSONObject.
     * @param jwt The JSON web token
     */
    JSONObject parseJWT(String jwt) throws InvalidJWTException;
}
