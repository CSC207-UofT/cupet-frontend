package com.example.cupetfrontend.use_cases.request_models;

public class FetchPetProfileRequestModel {
    private final String token;
    private final String petId;

    public FetchPetProfileRequestModel(String token, String petId) {
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
