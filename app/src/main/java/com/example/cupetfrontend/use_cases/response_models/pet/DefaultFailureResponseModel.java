package com.example.cupetfrontend.use_cases.response_models.pet;

/**
 * A class representing the data returned in a response from a use case.
 * This class contains only an error message.
 */
public class DefaultFailureResponseModel {
    private final String errorMessage;

    public DefaultFailureResponseModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
