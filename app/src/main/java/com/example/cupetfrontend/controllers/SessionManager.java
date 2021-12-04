package com.example.cupetfrontend.controllers;

import com.example.cupetfrontend.controllers.abstracts.IJWTParser;
import com.example.cupetfrontend.controllers.abstracts.ISessionManager;
import com.example.cupetfrontend.controllers.cached_data_models.CachedUserData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A class responsible for storing the current session of the logged in user.
 */
public class SessionManager implements ISessionManager {
    private final IJWTParser jwtParser;
    private String userId;
    private String jwtToken;
    private CachedUserData cachedUserData;

    public SessionManager(IJWTParser jwtParser) {
        this.jwtParser = jwtParser;
    }

    @Override
    public String getToken() {
        return jwtToken;
    }

    @Override
    public void setToken(String token) {
        userId = jwtParser.getSubject(token);
        jwtToken = token;
    }

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public CachedUserData getCachedUserData() {
        return cachedUserData;
    }

    @Override
    public void setCachedUserData(CachedUserData cachedUserData) {
        this.cachedUserData = cachedUserData;
    }

    @Override
    public void clear() {
        userId = null;
        jwtToken = null;
        cachedUserData = null;
    }
}
