package com.example.cupetfrontend.use_cases.response_models.user;

public class UserCreatorFailResponseModel {
    private final String errorMessage;

    public UserCreatorFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
