package com.example.cupetfrontend.use_cases.response_models;

public class LoginSuccessResponseModel {
    private final String token;

    public LoginSuccessResponseModel(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
