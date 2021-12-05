package com.example.cupetfrontend.use_cases.response_models.user;

import com.example.cupetfrontend.use_cases.data_models.UserAccountWithoutPassword;

public class FetchUserAccountSuccessResponseModel extends UserAccountWithoutPassword {
    public FetchUserAccountSuccessResponseModel(String firstName, String lastName,
                                                String email, String homeAddress, String city) {
        super(firstName, lastName, email, homeAddress, city);
    }
}
