package com.example.cupetfrontend.use_cases.api_abstracts.request_models;

/**
 * A class defining the data needed for a create user request
 * to the API.
 */
public class APICreateUserRequestModel {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String homeAddress;

    public APICreateUserRequestModel(String firstName, String lastName, String email, String password, String homeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

}
