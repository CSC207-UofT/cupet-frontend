package com.example.cupetfrontend.use_cases.response_models.pet;

public class GetMatchesFailResponseModel {
    private final String errorMessage;

    public GetMatchesFailResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
