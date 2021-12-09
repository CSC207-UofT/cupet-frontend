package com.example.cupetfrontend.ui.create_pet;

/**
 * Create Pet result : success (pet details) or error message.
 */
public class CreatePetResult {
    private final boolean isError;
    private final String errorMessage;
    private final String petId;

    /**
     * Initialize an unsuccessful CreatePetResult
     *
     * @param isError      Whether or not an error occured
     * @param errorMessage The error message to display
     */
    public CreatePetResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
        this.petId = null;
    }

    /**
     * Initialize an unsuccessful CreatePetResult
     *
     * @param petId the id of the new pet
     */
    public CreatePetResult(String petId) {
        this.isError = false;
        this.errorMessage = null;
        this.petId = petId;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getPetId() {
        return petId;
    }
}
