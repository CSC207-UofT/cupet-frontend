package com.example.cupetfrontend.use_cases.request_models;

/**
 * A class containing the request data for creating a new user.
 */
public class UserCreatorRequestModel {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String homeAddress;
    private final String city;

    public UserCreatorRequestModel(String firstName, String lastName, String email,
                                   String password, String homeAddress, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public String getCity() {
        return city;
    }
}
