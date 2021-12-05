package com.example.cupetfrontend.drivers.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.cupetfrontend.controllers.InvalidJWTException;
import com.example.cupetfrontend.controllers.abstracts.IJWTParser;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class responsible for parsing a JSON web token
 */
public class JWTParser implements IJWTParser {
    @Override
    public String getSubject(String jwt) {
        try {
            DecodedJWT decodedJWT = JWT.decode(jwt);
            return decodedJWT.getSubject();
        } catch (JWTDecodeException e){
            throw new InvalidJWTException();
        }
    }
}
