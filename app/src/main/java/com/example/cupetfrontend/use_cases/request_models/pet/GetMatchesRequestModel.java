package com.example.cupetfrontend.use_cases.request_models.pet;

public class GetMatchesRequestModel extends PetDataFetchActionRequestModel{
    public GetMatchesRequestModel(String token, String petId) {
        super(token, petId);
    }
}
