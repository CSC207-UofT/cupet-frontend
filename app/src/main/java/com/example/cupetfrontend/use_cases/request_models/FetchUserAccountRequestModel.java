package com.example.cupetfrontend.use_cases.request_models;

public class FetchUserAccountRequestModel {
    private final String token;

    public FetchUserAccountRequestModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
