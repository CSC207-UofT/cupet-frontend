package com.example.cupetfrontend.use_cases.response_models.pet;

public class UnMatchPetFailureResponseModel {
    private final String message;

    public UnMatchPetFailureResponseModel(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
