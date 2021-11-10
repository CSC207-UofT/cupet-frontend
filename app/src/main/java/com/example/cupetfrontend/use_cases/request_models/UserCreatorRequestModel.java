package com.example.cupetfrontend.use_cases.request_models;

public class UserCreatorRequestModel {
    private final String firstName;
    private final String lastName;
    private final String homeAddress;
    private final String email;
    private final String password;

    public UserCreatorRequestModel(String firstName, String lastName, String homeAddress, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
