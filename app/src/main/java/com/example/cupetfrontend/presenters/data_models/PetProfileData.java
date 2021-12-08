package com.example.cupetfrontend.presenters.data_models;

public class PetProfileData {
    private final String name;
    private final String age;
    private final String breed;
    private final String biography;
    private final String imgUrl;

    public PetProfileData(String name, String age, String breed,
                          String biography, String imgUrl) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.biography = biography;
        this.imgUrl = imgUrl;
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

    public String getImgUrl() {
        return imgUrl;
    }
}
