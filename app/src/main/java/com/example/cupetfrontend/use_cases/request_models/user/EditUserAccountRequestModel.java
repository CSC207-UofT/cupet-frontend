package com.example.cupetfrontend.use_cases.request_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserAccount;

public class EditUserAccountRequestModel extends UserAccount {
    private final String token;

    public EditUserAccountRequestModel(String token,  String firstName, String lastName, String email,
                                       String homeAddress, String city, String password) {
        super(firstName, lastName, email, homeAddress, city, password);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
