package com.example.cupetfrontend.use_cases.response_models.pet;

public class RejectMatchFailResponseModel {
    private final String errorMessage;

    public RejectMatchFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
