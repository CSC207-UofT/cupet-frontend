package com.example.cupetfrontend.use_cases.request_models;

public class UserCreatorRequestModel {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String homeAddress;

    public UserCreatorRequestModel(String firstName, String lastName, String email, String password, String homeAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.homeAddress = homeAddress;
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
