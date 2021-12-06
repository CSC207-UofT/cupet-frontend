package com.example.cupetfrontend.presenters.view_model_abstracts.data_models;

public class ContactInfoData {
    private final String email;
    private final String phoneNumber;
    private final String facebook;
    private final String instagram;
    private final String profileImgUrl;

    public ContactInfoData(String email, String phoneNumber, String facebook, String instagram, String profileImgUrl) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.facebook = facebook;
        this.instagram = instagram;
        this.profileImgUrl = profileImgUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }
}
