package com.example.cupetfrontend.use_cases.data_models;

/**
 * A data class representing a user's profile
 */
public class UserProfile {
    private final String biography;
    private final String instagram;
    private final String facebook;
    private final String phoneNumber;

    public UserProfile(String biography, String instagram, String facebook, String phoneNumber) {
        this.biography = biography;
        this.instagram = instagram;
        this.facebook = facebook;
        this.phoneNumber = phoneNumber;
    }

    public String getBiography() {
        return biography;
    }

    public String getInstagram() {
        return instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
