package com.example.cupetfrontend.use_cases.request_models.user;

public class EditUserProfileRequestModel {
    private final String token;
    private final String newBiography;
    private final String newInstagram;
    private final String newFacebook;
    private final String newPhoneNumber;

    public EditUserProfileRequestModel(String token, String newBiography, String newInstagram, String newFacebook, String newPhoneNumber) {
        this.token = token;
        this.newBiography = newBiography;
        this.newInstagram = newInstagram;
        this.newFacebook = newFacebook;
        this.newPhoneNumber = newPhoneNumber;
    }

    public String getToken() {
        return token;
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
