package com.example.cupetfrontend.use_cases.data_models;

public class UserAccount extends UserAccountWithoutPassword{
    private final String password;

    public UserAccount(String firstName, String lastName, String email, String homeAddress, String city, String password) {
        super(firstName, lastName, email, homeAddress, city);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
