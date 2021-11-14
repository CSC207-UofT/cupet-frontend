package com.example.cupetfrontend.use_cases.response_models.pet;

public class FetchPetProfileSuccessResponseModel {
    private final String name;
    private final String age;
    private final String breed;
    private final String biography;

    public FetchPetProfileSuccessResponseModel(String name, String age, String breed, String biography) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.biography = biography;
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
}
