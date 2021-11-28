package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.FetchPetProfileRequestModel;

public class APIFetchPetProfileRequestModel extends FetchPetProfileRequestModel {
    public APIFetchPetProfileRequestModel(String token, String petId) {
        super(token, petId);
    }
}
