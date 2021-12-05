package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;

public class APIFetchPetProfileImageRequestModel extends FetchPetProfileRequestModel {
    public APIFetchPetProfileImageRequestModel(String token, String petId) {
        super(token, petId);
    }
}
