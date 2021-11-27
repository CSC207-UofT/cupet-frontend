package com.example.cupetfrontend.use_cases.response_models.pet;

public class UnMatchPetFailureResponseModel {
    private final String errorMessage;

    public UnMatchPetFailureResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
