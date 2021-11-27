package com.example.cupetfrontend.use_cases.response_models.user;

public class SetUserProfileImageFailResponseModel {
    private final String errorMessage;

    public SetUserProfileImageFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
