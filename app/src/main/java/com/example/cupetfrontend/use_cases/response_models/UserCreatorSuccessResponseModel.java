package com.example.cupetfrontend.use_cases.response_models;

public class UserCreatorSuccessResponseModel {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String homeAddress;
    private final String city;
    private final String userId;

    public UserCreatorSuccessResponseModel(String firstName, String lastName,
                                           String email, String homeAddress, String city,
                                           String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeAddress = homeAddress;
        this.city = city;
        this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public String getCity() {
        return city;
    }
}
