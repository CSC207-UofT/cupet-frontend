package com.example.cupetfrontend.use_cases.data_models;

/**
 * A class representing all data stored for a particular pet
 */
public class PetData extends PetProfile{
    private final String petId;
    private final String profileImgUrl;

    public PetData(String name, String age, String breed, String biography, String profileImgUrl, String petId) {
        super(name, age, breed, biography);
        this.petId = petId;
        this.profileImgUrl = profileImgUrl;
    }

    public String getPetId() {
        return petId;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }
}
