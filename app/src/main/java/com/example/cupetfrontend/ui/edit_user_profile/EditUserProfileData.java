package com.example.cupetfrontend.ui.edit_user_profile;

public class EditUserProfileData {
    private String biography;
    private String phoneNumber;
    private String facebook;
    private String instagram;

    public EditUserProfileData(String biography, String phoneNumber,
                               String facebook, String instagram) {
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.facebook = facebook;
        this.instagram = instagram;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBiography() {
        return biography;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
