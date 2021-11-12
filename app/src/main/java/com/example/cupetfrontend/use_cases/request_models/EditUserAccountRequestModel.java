package com.example.cupetfrontend.use_cases.request_models;

public class EditUserAccountRequestModel {
    private final String token;
    private final String newFirstName;
    private final String newLastName;
    private final String newEmail;
    private final String newPassword;
    private final String newHomeAddress;
    private final String newCity;

    public EditUserAccountRequestModel(String token, String newFirstName, String newLastName,
                                       String newEmail, String newPassword, String newHomeAddress, String newCity) {
        this.token = token;
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
        this.newEmail = newEmail;
        this.newPassword = newPassword;
        this.newHomeAddress = newHomeAddress;
        this.newCity = newCity;
    }

    public String getToken() {
        return token;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewHomeAddress() {
        return newHomeAddress;
    }

    public String getNewCity() {
        return newCity;
    }
}
