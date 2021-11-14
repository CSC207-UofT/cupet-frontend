package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IJWTParser;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import org.json.JSONException;
import org.json.JSONObject;

public class SessionManager implements ISessionManager {
    private IJWTParser jwtParser;
    private String userId;
    private String jwtToken;

    public SessionManager(IJWTParser jwtParser) {
        this.jwtParser = jwtParser;
    }

    @Override
    public String getToken() {
        return jwtToken;
    }

    @Override
    public void setToken(String token) throws InvalidJWTException{
        JSONObject jwtBody = jwtParser.parseJWT(token);

        try {
            userId = jwtBody.getString("userId");
            jwtToken = token;
        } catch (JSONException e) {
            throw new InvalidJWTException();
        }
    }

    @Override
    public String getUserId() {
        return userId;
    }
}
