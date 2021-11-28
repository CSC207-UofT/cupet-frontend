package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserAccount;

public class UserCreatorSuccessResponseModel extends UserAccount {
    public UserCreatorSuccessResponseModel(String firstName, String lastName,
                                           String email, String homeAddress, String city, String password) {
        super(firstName, lastName, email, homeAddress, city, password);
    }
}
