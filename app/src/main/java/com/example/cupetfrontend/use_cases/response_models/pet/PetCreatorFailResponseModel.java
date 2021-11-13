package com.example.cupetfrontend.use_cases.response_models.pet;

public class PetCreatorFailResponseModel {
    private final String errorMessage;

    public PetCreatorFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
