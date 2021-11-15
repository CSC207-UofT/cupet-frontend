package com.example.cupetfrontend.use_cases.response_models.user;

public class EditUserProfileSuccessResponseModel {
    private final String newBiography;
    private final String newInstagram;
    private final String newFacebook;
    private final String newPhoneNumber;

    public EditUserProfileSuccessResponseModel(String newBiography, String newInstagram, String newFacebook, String newPhoneNumber) {
        this.newBiography = newBiography;
        this.newInstagram = newInstagram;
        this.newFacebook = newFacebook;
        this.newPhoneNumber = newPhoneNumber;
    }

    public String getNewBiography() {
        return newBiography;
    }

    public String getNewInstagram() {
        return newInstagram;
    }

    public String getNewFacebook() {
        return newFacebook;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }
}
