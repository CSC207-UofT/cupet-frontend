package com.example.cupetfrontend.controllers.cached_data_models;

public class CachedUserData {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String profileImgUrl;

    public CachedUserData(String firstName, String lastName, String email, String profileImgUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profileImgUrl = profileImgUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }
}
