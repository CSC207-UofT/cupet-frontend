package com.example.cupetfrontend.use_cases.request_models.pet;

public class RejectMatchRequestModel extends MatchActionRequestModel{
    public RejectMatchRequestModel(String token, String myPetId, String otherPetId) {
        super(token, myPetId, otherPetId);
    }
}
