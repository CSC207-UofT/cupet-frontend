package com.example.cupetfrontend.use_cases.response_models.pet;

public class PetCreatorSuccessResponseModel {
    private final String name;
    private final String age;
    private final String breed;
    private final String biography;
    private final String petId;

    public PetCreatorSuccessResponseModel(String name, String age, String breed, String biography, String petId) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.biography = biography;
        this.petId = petId;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getBreed() {
        return breed;
    }

    public String getBiography() {
        return biography;
    }

    public String getPetId() {
        return petId;
    }
}
