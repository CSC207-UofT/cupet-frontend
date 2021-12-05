package com.example.cupetfrontend.ui.my_pet_profile;

/**
 * Fetch Pet Profile result : success (pet details) or error message.
 */
public class PetProfileResult {
    private final boolean isError;
    private final String errorMessage;
    private String petName;
    private String petAge;
    private String petBreed;
    private String petBio;


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

    public String getPetName() {
        return petName;
    }

    public String getPetAge() {
        return petAge;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetBio() {
        return petBio;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetBio(String petBio) {
        this.petBio = petBio;
    }
}
