package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

public class APIFetchPetProfileRequestModel {
    private final String token;
    private final String petId;

    public APIFetchPetProfileRequestModel(String token, String petId) {
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
