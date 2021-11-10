package com.example.cupetfrontend.use_cases.response_models;

public class UserCreatorFailResponseModel {
    private final String message;

    public UserCreatorFailResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
