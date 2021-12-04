package com.example.cupetfrontend.use_cases.request_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserAccount;

public class EditUserAccountRequestModel extends UserAccount {
    private final String token;

    /**
     * Initialize an EditUserAccountRequestModel with a password.
     */
    public EditUserAccountRequestModel(String token,  String firstName, String lastName, String email,
                                       String password, String homeAddress, String city) {
        super(firstName, lastName, email, password, homeAddress, city);
        this.token = token;
    }

    /**
     * Initialize an EditUserAccountRequestModel without a password.
     */
    public EditUserAccountRequestModel(String token,  String firstName, String lastName, String email,
                                       String homeAddress, String city) {
        super(firstName, lastName, email, null, homeAddress, city);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
