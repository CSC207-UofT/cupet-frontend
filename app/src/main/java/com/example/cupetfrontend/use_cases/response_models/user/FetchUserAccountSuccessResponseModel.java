package com.example.cupetfrontend.use_cases.response_models.user;

public class FetchUserAccountSuccessResponseModel {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String homeAddress;
    private final String city;

    public FetchUserAccountSuccessResponseModel(String firstName, String lastName, String email,
                                                String homeAddress, String city) {
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
