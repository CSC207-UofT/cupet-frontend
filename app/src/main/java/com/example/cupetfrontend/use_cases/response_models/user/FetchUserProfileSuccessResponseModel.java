package com.example.cupetfrontend.use_cases.response_models.user;

public class FetchUserProfileSuccessResponseModel {
    private final String firstName;
    private final String lastName;
    private final String biography;
    private final String instagram;
    private final String facebook;
    private final String phoneNumber;

    public FetchUserProfileSuccessResponseModel(String firstName, String lastName, String biography, String instagram, String facebook, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.instagram = instagram;
        this.facebook = facebook;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
