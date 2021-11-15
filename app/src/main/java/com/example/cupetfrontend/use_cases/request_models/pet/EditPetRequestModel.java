package com.example.cupetfrontend.use_cases.request_models.pet;

public class EditPetRequestModel {
    private final String token;
    private final String petId;
    private final String newName;
    private final String newAge;
    private final String newBreed;
    private final String newBiography;

    public EditPetRequestModel(String token, String petId, String newName, String newAge, String newBreed, String newBiography) {
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
