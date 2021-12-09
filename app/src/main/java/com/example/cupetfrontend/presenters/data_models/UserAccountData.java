package com.example.cupetfrontend.presenters.data_models;

import com.example.cupetfrontend.use_cases.response_models.user.FetchUserAccountSuccessResponseModel;

public class UserAccountData extends FetchUserAccountSuccessResponseModel {
    public UserAccountData(String firstName, String lastName,
                           String email, String homeAddress, String city) {
        super(firstName, lastName, email, homeAddress, city);
    }
}
