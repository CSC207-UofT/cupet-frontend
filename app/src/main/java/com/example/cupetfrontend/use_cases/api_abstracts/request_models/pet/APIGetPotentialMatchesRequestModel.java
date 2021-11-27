package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.GetPotentialMatchesRequestModel;

public class APIGetPotentialMatchesRequestModel extends GetPotentialMatchesRequestModel {
    public APIGetPotentialMatchesRequestModel(String token, String petId) {
        super(token, petId);
    }
}
