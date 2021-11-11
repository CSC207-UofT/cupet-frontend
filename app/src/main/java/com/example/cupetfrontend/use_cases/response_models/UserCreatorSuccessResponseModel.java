package com.example.cupetfrontend.use_cases.response_models;

public class UserCreatorSuccessResponseModel {
    private final String message;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String homeAddress;
    private final String userId;

    public UserCreatorSuccessResponseModel(String message, String firstName, String lastName,
                                           String email, String homeAddress, String userId) {
        this.message = message;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.homeAddress = homeAddress;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
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


}
