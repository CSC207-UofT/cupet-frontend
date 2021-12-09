package com.example.cupetfrontend.use_cases.request_models.pet;

public class IntendToMatchRequestModel extends MatchActionRequestModel {
    public IntendToMatchRequestModel(String token, String myPetId, String otherPetId) {
        super(token, myPetId, otherPetId);
    }
}
