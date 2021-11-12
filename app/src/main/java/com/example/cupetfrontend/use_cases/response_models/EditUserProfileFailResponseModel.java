package com.example.cupetfrontend.use_cases.response_models;

public class EditUserProfileFailResponseModel {
    private final String errorMessage;

    public EditUserProfileFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
