package com.example.cupetfrontend.use_cases.response_models;

public class LoginFailResponseModel {
    private final String errorMessage;

    public LoginFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
