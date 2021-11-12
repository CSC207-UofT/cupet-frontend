package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

public class APIFetchUserAccountRequestModel {
    private final String token;

    public APIFetchUserAccountRequestModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
