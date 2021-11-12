package com.example.cupetfrontend.use_cases.response_models;

public class GetPetsFailResponseModel {
    private final String errorMessage;

    public GetPetsFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
