package com.example.cupetfrontend.use_cases.response_models.pet;

public class IntendToMatchFailResponseModel {
    private final String errorMessage;

    public IntendToMatchFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
