package com.example.cupetfrontend.data.model;


/**
 * Data class that captures pet information retrieved from Responses
 */
public class PetModel {

    private String petId;
    private String petName;
    private String petBreed;
    private String petImageUrl;
    private String petBio;
    private String petAge;
    private String userId;

    public PetModel(String petId, String petName, String petAge, String petBreed, String petBio,
                      String petImageUrl, String userId) {
        this.petId = petId;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petImageUrl = petImageUrl;
        this.petBio = petBio;
        this.petAge = petAge;
        this.userId = userId;
    }


    public String getPetId() {
        return petId;
    }

    public String getPetName() {
        return petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public String getPetImageUrl() {
        return petImageUrl;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public void setPetImageUrl(String petImageUrl) {
        this.petImageUrl = petImageUrl;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPetBio() {
        return petBio;
    }

    public void setPetBio(String petBio) {
        this.petBio = petBio;
    }
}
