package com.example.cupetfrontend.use_cases.response_models.pet;

public class EditPetSuccessResponseModel {
    private final String newName;
    private final String newAge;
    private final String newBreed;
    private final String newBiography;

    public EditPetSuccessResponseModel(String newName, String newAge, String newBreed, String newBiography) {
        this.newName = newName;
        this.newAge = newAge;
        this.newBreed = newBreed;
        this.newBiography = newBiography;
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
