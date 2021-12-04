package com.example.cupetfrontend.ui.edit_pet;

/**
 * Edit Pet result : success (edited pet details) or error message.
 */
public class EditPetResult {
    private final boolean isError;
    private final String errorMessage;

    public EditPetResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    public EditPetResult(boolean isError) {
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
