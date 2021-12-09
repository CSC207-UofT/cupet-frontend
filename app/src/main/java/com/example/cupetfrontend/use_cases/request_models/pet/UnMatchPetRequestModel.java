package com.example.cupetfrontend.use_cases.request_models.pet;

public class UnMatchPetRequestModel extends MatchActionRequestModel {
    public UnMatchPetRequestModel(String token, String myPetId, String otherPetId) {
        super(token, myPetId, otherPetId);
    }
}
