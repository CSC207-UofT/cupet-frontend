package com.example.cupetfrontend.use_cases.data_models;

/**
 * A class representing all data stored for a particular pet
 */
public class PetData extends PetProfile {
    private final String petId;
    private final String profileImgUrl;
    private final String userId;

    public PetData(String name, String age, String breed, String biography,
                   String profileImgUrl, String petId, String userId) {
        super(name, age, breed, biography);
        this.petId = petId;
        this.profileImgUrl = profileImgUrl;
        this.userId = userId;
    }

    public String getPetId() {
        return petId;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public String getUserId() {
        return userId;
    }
}
