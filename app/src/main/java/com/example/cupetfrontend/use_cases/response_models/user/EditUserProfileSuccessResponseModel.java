package com.example.cupetfrontend.use_cases.response_models.user;

public class EditUserProfileSuccessResponseModel {
    private final String newBiography;

    public EditUserProfileSuccessResponseModel(String newBiography) {
        this.newBiography = newBiography;
    }

    public String getNewBiography() {
        return newBiography;
    }
}
