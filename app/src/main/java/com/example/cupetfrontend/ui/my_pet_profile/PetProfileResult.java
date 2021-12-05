package com.example.cupetfrontend.ui.my_pet_profile;

/**
 * Fetch Pet Profile result : success (pet details) or error message.
 */
public class PetProfileResult {
    private final boolean isError;
    private final String errorMessage;
    private String petImage;
    private String petName;
    private String petAge;
    private String petBreed;
    private String petBio;


    public PetProfileResult(boolean isError, String errorMessage) {
        this.isError = isError;
        this.errorMessage = errorMessage;
    }

    /**
     * Initialize a successful pet profile result
     */
    public PetProfileResult(String petImage, String petName, String petAge, String petBreed, String petBio) {
        this.isError = false;
        this.errorMessage = null;
        this.petImage = petImage;
        this.petName = petName;
        this.petAge = petAge;
        this.petBreed = petBreed;
        this.petBio = petBio;
    }

    public boolean isError() {
        return isError;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getPetImage() {
        return petImage;
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

    public void setPetImage(String petImage) {
        this.petImage = petImage;
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
