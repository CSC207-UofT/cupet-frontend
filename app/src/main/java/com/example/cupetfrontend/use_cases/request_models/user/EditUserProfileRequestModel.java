package com.example.cupetfrontend.use_cases.request_models.user;

public class EditUserProfileRequestModel {
    private final String token;
    private final String newBiography;

    public EditUserProfileRequestModel(String token, String newBiography) {
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
