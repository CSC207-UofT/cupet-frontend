package com.example.cupetfrontend.use_cases.response_models.user;

public class FetchUserProfileSuccessResponseModel {
    private final String firstName;
    private final String lastName;
    private final String biography;

    public FetchUserProfileSuccessResponseModel(String firstName, String lastName, String biography) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
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
}
