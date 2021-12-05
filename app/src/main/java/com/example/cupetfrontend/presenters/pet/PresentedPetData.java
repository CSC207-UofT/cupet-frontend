package com.example.cupetfrontend.presenters.pet;

public class PresentedPetData {
    private final String name;
    private final String age;
    private final String breed;
    private final String biography;
    private final String profileImgUrl;
    private final String petId;

    public PresentedPetData(String name, String age, String breed, String biography, String profileImgUrl, String petId) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.biography = biography;
        this.profileImgUrl = profileImgUrl;
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

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public String getPetId() {
        return petId;
    }
}
