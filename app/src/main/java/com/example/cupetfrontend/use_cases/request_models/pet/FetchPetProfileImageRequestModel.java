package com.example.cupetfrontend.use_cases.request_models.pet;

public class FetchPetProfileImageRequestModel extends PetDataFetchActionRequestModel {
    public FetchPetProfileImageRequestModel(String token, String petId) {
        super(token, petId);
    }
}
