package com.example.cupetfrontend.use_cases.response_models.pet;

public class GetPotentialMatchesFailResponseModel {
    private final String errorMessage;

    public GetPotentialMatchesFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
