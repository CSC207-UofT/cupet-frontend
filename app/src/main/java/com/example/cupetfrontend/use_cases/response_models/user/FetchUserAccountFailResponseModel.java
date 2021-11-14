package com.example.cupetfrontend.use_cases.response_models.user;

public class FetchUserAccountFailResponseModel {
    private final String errorMessage;

    public FetchUserAccountFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
