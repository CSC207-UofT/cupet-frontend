package com.example.cupetfrontend.use_cases.response_models.pet;

public class EditPetFailResponseModel {
    private final String errorMessage;

    public EditPetFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
