package com.example.cupetfrontend.use_cases.response_models.user;

public class EditUserAccountSuccessResponseModel {
    private final String newFirstName;
    private final String newLastName;
    private final String newEmail;
    private final String newPassword;
    private final String newCurrentAddress;
    private final String newCity;

    public EditUserAccountSuccessResponseModel(String newFirstName, String newLastName, String newEmail, String newPassword, String newCurrentAddress, String newCity) {
        this.newFirstName = newFirstName;
        this.newLastName = newLastName;
        this.newEmail = newEmail;
        this.newPassword = newPassword;
        this.newCurrentAddress = newCurrentAddress;
        this.newCity = newCity;
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

    public String getNewCurrentAddress() {
        return newCurrentAddress;
    }

    public String getNewCity() {
        return newCity;
    }
}
