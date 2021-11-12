package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

public class APIFetchUserProfileRequestModel {
    private final String token;
    private final String userId;

    public APIFetchUserProfileRequestModel(String token, String userId) {
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
