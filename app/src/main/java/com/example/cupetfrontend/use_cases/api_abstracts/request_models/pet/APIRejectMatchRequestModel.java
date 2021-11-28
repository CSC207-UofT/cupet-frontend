package com.example.cupetfrontend.use_cases.api_abstracts.request_models.pet;

import com.example.cupetfrontend.use_cases.request_models.pet.RejectMatchRequestModel;

public class APIRejectMatchRequestModel extends RejectMatchRequestModel {
    public APIRejectMatchRequestModel(String token, String myPetId, String otherPetId) {
        super(token, myPetId, otherPetId);
    }
}
