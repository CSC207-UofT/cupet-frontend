package com.example.cupetfrontend.use_cases.request_models.user;

/**
 * A request model super-class for request models related to
 * requesting public user information (ex. their profile and profile picture)
 */
public class UserDataFetchActionRequestModel {
    private final String token;
    private final String userId;

    public UserDataFetchActionRequestModel(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public String getUserId() {
        return userId;
    }
}
