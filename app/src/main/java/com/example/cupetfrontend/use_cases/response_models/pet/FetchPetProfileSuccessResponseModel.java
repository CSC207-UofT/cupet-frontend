package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetProfile;

public class FetchPetProfileSuccessResponseModel extends PetProfile {
    private final String profileImgUrl;
    private final String userId;

    public FetchPetProfileSuccessResponseModel(String name, String age, String breed,
                                               String biography, String profileImgUrl, String userId) {
        super(name, age, breed, biography);
        this.profileImgUrl = profileImgUrl;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }
}
