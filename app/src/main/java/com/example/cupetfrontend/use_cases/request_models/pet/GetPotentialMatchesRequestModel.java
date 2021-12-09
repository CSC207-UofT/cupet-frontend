package com.example.cupetfrontend.use_cases.request_models.pet;

public class GetPotentialMatchesRequestModel extends PetDataFetchActionRequestModel {
    public GetPotentialMatchesRequestModel(String token, String petId) {
        super(token, petId);
    }
}
