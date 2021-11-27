package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.IntendToMatchRequestModel;

public class APIIntendToMatchRequestModel extends IntendToMatchRequestModel {
    public APIIntendToMatchRequestModel(String token, String myPetId, String otherPetId) {
        super(token, myPetId, otherPetId);
    }
}
