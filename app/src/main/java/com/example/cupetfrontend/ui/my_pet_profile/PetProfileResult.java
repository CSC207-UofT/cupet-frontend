package com.example.cupetfrontend.ui.my_pet_profile;

/**
 * Fetch Pet Profile result : success (pet details) or error message.
 */
public class PetProfileResult {
    private final boolean isError;
    private final String errorMessage;

    public PetProfileResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public PetProfileResult(boolean isError) {
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
