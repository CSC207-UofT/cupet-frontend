package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.UnMatchPetRequestModel;

public class APIUnMatchPetRequestModel extends UnMatchPetRequestModel {
    public APIUnMatchPetRequestModel(String token, String myPetId, String otherPetId) {
        super(token, myPetId, otherPetId);
    }
}
