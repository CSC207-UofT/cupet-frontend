package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetProfile;

public class FetchPetProfileSuccessResponseModel extends PetProfile {
    private final String profileImgUrl;

    public FetchPetProfileSuccessResponseModel(String name, String age, String breed, String biography, String profileImgUrl) {
        super(name, age, breed, biography);
        this.profileImgUrl = profileImgUrl;
    }


    public String getProfileImgUrl() {
        return profileImgUrl;
    }
}
