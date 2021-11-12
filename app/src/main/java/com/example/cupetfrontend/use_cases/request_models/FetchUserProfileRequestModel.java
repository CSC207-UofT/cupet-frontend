package com.example.cupetfrontend.use_cases.request_models;

public class FetchUserProfileRequestModel {
    private final String token;
    private final String userId;

    public FetchUserProfileRequestModel(String token, String userId) {
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
