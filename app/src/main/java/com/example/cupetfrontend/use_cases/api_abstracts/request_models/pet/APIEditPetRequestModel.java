package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

public class APIEditPetRequestModel {
    private final String token;
    private final String petId;
    private final String newName;
    private final String newAge;
    private final String newBreed;
    private final String newBiography;

    public APIEditPetRequestModel(String token, String petId, String newName, String newAge, String newBreed, String newBiography) {
        this.token = token;
        this.petId = petId;
        this.newName = newName;
        this.newAge = newAge;
        this.newBreed = newBreed;
        this.newBiography = newBiography;
    }

    public String getToken() {
        return token;
    }

    public String getPetId() {
        return petId;
    }

    public String getNewName() {
        return newName;
    }

    public String getNewAge() {
        return newAge;
    }

    public String getNewBreed() {
        return newBreed;
    }

    public String getNewBiography() {
        return newBiography;
    }
}
