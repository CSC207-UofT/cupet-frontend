package com.example.cupetfrontend.use_cases.response_models.pet;

public class FetchPetProfileFailResponseModel {
    private final String errorMessage;

    public FetchPetProfileFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
