package com.example.cupetfrontend.use_cases.response_models.pet;

import com.example.cupetfrontend.use_cases.data_models.PetProfile;

public class FetchPetProfileSuccessResponseModel extends PetProfile {
    public FetchPetProfileSuccessResponseModel(String name, String age,
                                               String breed, String biography) {
        super(name, age, breed, biography);
    }
}
