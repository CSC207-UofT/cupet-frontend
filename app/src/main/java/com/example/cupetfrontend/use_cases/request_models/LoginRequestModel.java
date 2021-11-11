package com.example.cupetfrontend.use_cases.request_models;

/**
 * A class containing the request data for logging in a user.
 */
public class LoginRequestModel {
    private final String email;
    private final String password;

    public LoginRequestModel(String email, String password) {
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
