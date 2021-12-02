package com.example.cupetfrontend.use_cases.data_models;

/**
 * A data class representing a user's account (without its password)
 */
public class UserAccountWithoutPassword {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String homeAddress;
    private final String city;

    public UserAccountWithoutPassword(String firstName, String lastName, String email, String homeAddress, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeAddress = homeAddress;
        this.city = city;
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

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getCity() {
        return city;
    }
}
