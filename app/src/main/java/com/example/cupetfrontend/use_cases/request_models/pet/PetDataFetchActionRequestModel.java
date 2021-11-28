package com.example.cupetfrontend.use_cases.request_models.pet;

/**
 * Superclass with method and attributes for requests which generally deal with
 * some action relating to fetching pet data
 */
public class PetDataFetchActionRequestModel {
    private final String token;
    private final String petId;

    public PetDataFetchActionRequestModel(String token, String petId) {
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
