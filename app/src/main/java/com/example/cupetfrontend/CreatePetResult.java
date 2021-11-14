package com.example.cupetfrontend;

public class CreatePetResult {
    private final boolean isError;
    private final String errorMessage;

    public CreatePetResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public CreatePetResult(boolean isError) {
        this.isError = isError;
        errorMessage = "";
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}