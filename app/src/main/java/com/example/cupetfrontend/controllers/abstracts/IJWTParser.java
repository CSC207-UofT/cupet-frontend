package com.example.cupetfrontend.controllers.abstracts;

import com.example.cupetfrontend.controllers.InvalidJWTException;
import org.json.JSONObject;

public interface IJWTParser {
    /**
     * Parse a JSON Web token and return the JWT's subject
     * @param jwt The JSON web token
     */
    String getSubject(String jwt);
}
