package com.example.cupetfrontend.use_cases.request_models.pet;

public class GetPotentialMatchesRequestModel {
    private final String token;
    private final String petId;

    public GetPotentialMatchesRequestModel(String token, String petId) {
        this.token = token;
        this.petId = petId;
    }

    public String getToken() {
        return token;
    }

    public String getPetId() {
        return petId;
    }
}
