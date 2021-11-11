package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

/**
 * A class defining the data needed to log a user in using the API.
 */
public class APILoginRequestModel {
    private final String email;
    private final String password;

    public APILoginRequestModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
