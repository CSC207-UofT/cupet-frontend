package com.example.cupetfrontend.use_cases.response_models.user;

public class SetPetProfileImageFailResponseModel {
    private final String errorMessage;

    public SetPetProfileImageFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
