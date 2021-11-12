package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

public class APIEditUserProfileRequestModel {
    private final String token;
    private final String newBiography;

    public APIEditUserProfileRequestModel(String token, String newBiography) {
        this.token = token;
        this.newBiography = newBiography;
    }

    public String getToken() {
        return token;
    }

    public String getNewBiography() {
        return newBiography;
    }
}
