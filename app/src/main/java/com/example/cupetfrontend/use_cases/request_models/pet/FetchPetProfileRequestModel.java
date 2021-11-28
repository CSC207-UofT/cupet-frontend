package com.example.cupetfrontend.use_cases.request_models.pet;

public class FetchPetProfileRequestModel extends PetDataFetchActionRequestModel{
    public FetchPetProfileRequestModel(String token, String petId) {
        super(token, petId);
    }
}
