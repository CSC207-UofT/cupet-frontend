package com.example.cupetfrontend.use_cases.response_models.user;

public class EditUserAccountFailResponseModel {
    private final String errorMessage;

    public EditUserAccountFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
